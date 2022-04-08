package com.store.api;

import com.store.api.domain.Authority;
import com.store.api.domain.AuthorityKey;
import com.store.api.domain.User;
import com.store.api.repository.AuthorityRepository;
import com.store.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


	@Bean
	public CommandLineRunner test(UserRepository userRepository,
																AuthorityRepository authorityRepository,
																PasswordEncoder encoder) {
		return (args) -> {

			User user = new User();
			user.setUsername("user");
			user.setPassword(encoder.encode("user"));
			user.setEnabled(true);

			userRepository.save(user);

			Authority authority = new Authority();
			authority.setAuthorityKey(new AuthorityKey(user.getUsername(), "ROLE_ADMIN"));
			authority.setUser(user);

			authorityRepository.save(authority);

			authority = new Authority();

			authority.setAuthorityKey(new AuthorityKey(user.getUsername(), "ROLE_DEVELOPER"));
			authority.setUser(user);
			authorityRepository.save(authority);

		};
	}


}
