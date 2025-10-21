package com.springboot.adakita.adakita.repository;

import com.springboot.adakita.adakita.entity.AccountPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountPersonalRepository extends JpaRepository<AccountPersonal, Integer> {
    Optional<AccountPersonal> findByUsername(String username);
}
