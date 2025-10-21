package com.springboot.adakita.adakita.repository;

import com.springboot.adakita.adakita.entity.AccountPersonal;
import com.springboot.adakita.adakita.entity.AccountPerusahaan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountPerusahaanRepository extends JpaRepository<AccountPerusahaan, Integer> {
    Optional<AccountPerusahaan> findByUsername(String username);
}
