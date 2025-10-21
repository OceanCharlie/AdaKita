package com.springboot.adakita.adakita.service;

import com.springboot.adakita.adakita.entity.Account;
import com.springboot.adakita.adakita.entity.AccountPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.adakita.adakita.repository.AccountPersonalRepository;
import java.util.List;

@Service
public class AccountPersonalService {

    @Autowired
    AccountPersonalRepository accountPersonalRepository;

    public List<AccountPersonal> getAllUsers() {
        return accountPersonalRepository.findAll();
    }

    public AccountPersonal getAccountById(int user_id) {
        return accountPersonalRepository.findById(user_id).orElse(null);
    }

    public Account updateAccount(int account_id, AccountPersonal account) {
        account.setAccount_id(account_id);
        return accountPersonalRepository.save(account);
    }

    public void deleteAccount(int user_id) {
        accountPersonalRepository.deleteById(user_id);
    }

    public void saveAccount(AccountPersonal accountPersonal) {
        accountPersonalRepository.save(accountPersonal);
    }

    public AccountPersonal getAccountByUsername(String username) {
        return accountPersonalRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User not found"));
    }
}

