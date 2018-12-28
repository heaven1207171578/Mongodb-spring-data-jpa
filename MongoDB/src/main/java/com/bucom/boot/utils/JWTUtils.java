package com.bucom.boot.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
/**
 * Created by Administrator on 2018/4/11.
 */
@ConfigurationProperties("jwt.config")
public class JWTUtils {


        private String key ;//盐

        private long ttl ;//过期时间

    public JWTUtils() {
    }

    /**
         * 生成JWT
         *
         * @param id
         * @param subject
         * @return
         */
        public String createJWT(String id, String subject, String roles) {
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            JwtBuilder builder = Jwts.builder().setId(id)
                    .setSubject(subject)
                    .setIssuedAt(now)
                    .signWith(SignatureAlgorithm.HS256, key).claim("roles", roles);
            if (ttl > 0) {
                builder.setExpiration( new Date( nowMillis + ttl));
            }
            return builder.compact();
        }

        /**
         * 解析JWT
         * @param jwtStr
         * @return
         */
        public Claims parseJWT(String jwtStr){
            return  Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwtStr)
                    .getBody();
        }

    public String getKey() {
        return this.key;
    }

    public long getTtl() {
        return this.ttl;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof JWTUtils)) return false;
        final JWTUtils other = (JWTUtils) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$key = this.getKey();
        final Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) return false;
        if (this.getTtl() != other.getTtl()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof JWTUtils;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $key = this.getKey();
        result = result * PRIME + ($key == null ? 43 : $key.hashCode());
        final long $ttl = this.getTtl();
        result = result * PRIME + (int) ($ttl >>> 32 ^ $ttl);
        return result;
    }

    public String toString() {
        return "JWTUtils(key=" + this.getKey() + ", ttl=" + this.getTtl() + ")";
    }
}

