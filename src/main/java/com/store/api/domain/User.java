package com.store.api.domain;

import com.store.api.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
public class User {


  @Id
  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  private Boolean enabled;

  @OneToMany(mappedBy = "user")
  private List<Authority> authorities = new ArrayList<>();

  public static User convert(UserDto dto) {
    User user = new User();
    user.setEnabled(dto.getEnabled());
    user.setPassword(dto.getPassword());
    user.setUsername(dto.getUserName());
    return user;
  }
}
