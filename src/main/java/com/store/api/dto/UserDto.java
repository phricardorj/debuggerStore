package com.store.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserDto {
  private String userName;
  private String password;
  private Boolean enabled;
  private List<String> roles;
}
