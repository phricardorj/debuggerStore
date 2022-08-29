package com.store.api.repository;

import com.store.api.domain.Authority;
import com.store.api.domain.AuthorityKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, AuthorityKey> {
}
