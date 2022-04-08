package com.store.api.controller;

import com.store.api.dto.UserDto;
import com.store.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store/user")
public class UserController {

  private final UserService userService;

  @GetMapping
  public Principal getActualUser(Principal principal){return principal;}

  @PostMapping
  public UserDto createNewUser(@RequestBody UserDto userDto){
   return userService.createUser(userDto);
  }

}
