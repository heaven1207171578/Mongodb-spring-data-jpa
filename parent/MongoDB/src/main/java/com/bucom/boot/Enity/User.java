package com.bucom.boot.Enity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
  @Id private String id;
  private String userName;
  private String passWord;
  private Object roles;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public Object getRoles() {
    return roles;
  }

  public void setRoles(Object roles) {
    this.roles = roles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return Objects.equals(getId(), user.getId())
        && Objects.equals(getUserName(), user.getUserName())
        && Objects.equals(getPassWord(), user.getPassWord())
        && Objects.equals(getRoles(), user.getRoles());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getId(), getUserName(), getPassWord(), getRoles());
  }
}
