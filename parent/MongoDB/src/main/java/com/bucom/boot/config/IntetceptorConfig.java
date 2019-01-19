package com.bucom.boot.config;

import com.bucom.boot.interceptor.JWTInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class IntetceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JWTInterceptor jwtInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(jwtInterceptor)
                .addPathPatterns("/**") // 添加拦截的路径
                .excludePathPatterns("/**/login/**"); // 排除拦截的路径
    }

    //jackson:string转map
    public static void main(String[] args) throws IOException {
        String json =
                "{\"goods_id\":\"140861765\",\"cat_id\":\"210\",\"goods_sn\":\"171073501\",\"goods_sn_back\":\"171073501\",\"goods_upc\":null,\"goods_name\":\"Lace-Up Boxer Swimming Trunks\"}";
        System.out.println(json);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> tomap = objectMapper.readValue(json, map.getClass());
        tomap.entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
    }
}
