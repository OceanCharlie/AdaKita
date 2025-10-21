package com.springboot.adakita.adakita.service;

import com.springboot.adakita.adakita.entity.Account;
import com.springboot.adakita.adakita.entity.AccountPerusahaan;
import com.springboot.adakita.adakita.repository.AccountPerusahaanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountPerusahaanService {

    @Autowired
    AccountPerusahaanRepository accountPerusahaanRepository;

    public List<AccountPerusahaan> getAllUsers() {
        return accountPerusahaanRepository.findAll();
    }

    public AccountPerusahaan getAccountById(int user_id) {
        return accountPerusahaanRepository.findById(user_id).orElse(null);
    }

    public AccountPerusahaan addAccount(AccountPerusahaan account) {
        return accountPerusahaanRepository.save(account);
    }

    public Account updateAccount(int account_id, AccountPerusahaan account) {
        account.setAccount_id(account_id);
        return accountPerusahaanRepository.save(account);
    }

    public void deleteUser(int user_id) {
        accountPerusahaanRepository.deleteById(user_id);
    }

    public void save(AccountPerusahaan accountPerusahaan) {
        accountPerusahaanRepository.save(accountPerusahaan);
    }
}
