package com.store.api.service;

import com.store.api.dto.UserDto;
import com.store.api.domain.Authority;
import com.store.api.domain.User;
import com.store.api.repository.AuthorityRepository;
import com.store.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final AuthorityRepository authorityRepository;
  private final PasswordEncoder passwordEncoder;

  public UserDto createUser(UserDto userDto) {

    if (userDto.getPassword() == null) {
      throw new NullPointerException();
    }

    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
    User user = User.convert(userDto);

    final User userDB = userRepository.save(user);

    userDto.getRoles()
        .forEach(a -> saveAuthority(userDB, a));

    return userDto;
  }

  public void saveAuthority(User user, String role) {
    Authority authority = Authority.convert(user, "ROLE_" + role);
    authorityRepository.save(authority);
  }

}
