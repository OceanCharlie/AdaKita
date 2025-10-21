package com.springboot.adakita.adakita.controller;

import com.springboot.adakita.adakita.entity.AccountPersonal;
import com.springboot.adakita.adakita.service.AccountPersonalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/personal")
public class PersonalController {

    private AccountPersonalService accountPersonalService;

    @Autowired
    public PersonalController(AccountPersonalService accountPersonalService) {
        this.accountPersonalService = accountPersonalService;
    }

    public Integer getAccountId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        String username = user.getUsername();

        AccountPersonal logedInAccount = accountPersonalService.getAccountByUsername(username);

        return logedInAccount.getAccount_id();
    }

    @GetMapping("/profile")
    public String accountProfile(Model theModel) {

        int accountId = getAccountId();
        AccountPersonal accountPersonal = accountPersonalService.getAccountById(accountId);
            theModel.addAttribute("account_profile", accountPersonal);
            return "/profile/profile-personal";
    }

    @GetMapping("/profile/edit")
    public String EditProfile(Model theModel) {

            AccountPersonal theAccount = accountPersonalService.getAccountById(getAccountId());

            theModel.addAttribute("account", theAccount);

            return "edit/edit-personal";

    }

    @PostMapping("/profile/save")
    public String saveEdit(@ModelAttribute("account") AccountPersonal theAccount) {

        AccountPersonal existingAccount = accountPersonalService.getAccountById(theAccount.getAccount_id());

        if (existingAccount == null) {
            throw new IllegalArgumentException("Akun tidak ditemukan");
        }

        if (!existingAccount.getUsername().equals(theAccount.getUsername())) {
            // Update data
            existingAccount.setUsername(theAccount.getUsername());
            accountPersonalService.saveAccount(existingAccount);

            // Logout pengguna
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                return "/logout";
            }

            return "redirect:/login?message=usernameChanged";
        }

        existingAccount.setName(theAccount.getName() != null ? theAccount.getName() : existingAccount.getName());
        existingAccount.setPassword(theAccount.getPassword() != null && !theAccount.getPassword().isEmpty() ? theAccount.getPassword() : existingAccount.getPassword());
        existingAccount.setGmail(theAccount.getGmail() != null ? theAccount.getGmail() : existingAccount.getGmail());
        existingAccount.setDate(theAccount.getDate() != null ? theAccount.getDate() : existingAccount.getDate());
        existingAccount.setNik(theAccount.getNik() != 0 ? theAccount.getNik() : existingAccount.getNik());
        existingAccount.setTelp_number(theAccount.getTelp_number() != 0 ? theAccount.getTelp_number() : existingAccount.getTelp_number());
        existingAccount.setAmountTransaction(theAccount.getAmountTransaction() != 0 ? theAccount.getAmountTransaction() : existingAccount.getAmountTransaction());
        existingAccount.setPendidikan(theAccount.getPendidikan() != null ? theAccount.getPendidikan() : existingAccount.getPendidikan());
        existingAccount.setPekerjaan(theAccount.getPekerjaan() != null? theAccount.getPekerjaan() : existingAccount.getPekerjaan());

        accountPersonalService.saveAccount(existingAccount);

        // use a redirect to prevent duplicate submissions
        return "redirect:/personal/profile";
    }
}
