package com.springboot.adakita.adakita.service;

import com.springboot.adakita.adakita.entity.AccountPersonal;
import com.springboot.adakita.adakita.entity.AccountPerusahaan;
import com.springboot.adakita.adakita.repository.AccountPersonalRepository;
import com.springboot.adakita.adakita.repository.AccountPerusahaanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    AccountPerusahaanRepository accountPerusahaanRepo;
    AccountPersonalRepository accountPersonalRepo;

    @Autowired
    public LoginService(AccountPersonalRepository accountPersonalRepo, AccountPerusahaanRepository accountPerusahaanRepo) {
        this.accountPerusahaanRepo = accountPerusahaanRepo;
        this.accountPersonalRepo = accountPersonalRepo;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AccountPersonal> userPersonal = accountPersonalRepo.findByUsername(username);
        if (userPersonal.isPresent()) {
            AccountPersonal userObj = userPersonal.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        }
        else {

            Optional<AccountPerusahaan> userPerusahaan = accountPerusahaanRepo.findByUsername(username);

            if (userPerusahaan.isPresent()) {
                AccountPerusahaan userObj = userPerusahaan.get();
                return User.builder()
                        .username(userObj.getUsername())
                        .password(userObj.getPassword())
                        .build();
            }
            else {
                throw new UsernameNotFoundException(username);
            }
        }
    }

    public AccountPersonal addUser(AccountPersonal account) {
        return accountPersonalRepo.save(account);
    }

    public void Logout() {
    }
}
