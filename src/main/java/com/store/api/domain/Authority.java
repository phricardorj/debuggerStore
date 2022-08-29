package com.store.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "authorities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

  @EmbeddedId
  private AuthorityKey authorityKey;

  @ManyToOne
  @MapsId("username")
  @JoinColumn(name = "username")
  private User user;

  public static Authority convert(User user, String role) {
    Authority authority = new Authority();

    AuthorityKey key = new AuthorityKey(user.getUsername(), role);
    authority.setUser(user);
    authority.setAuthorityKey(key);

    return authority;
  }
}
