package com.springboot.adakita.adakita.controller;

import java.util.List;

import com.springboot.adakita.adakita.entity.AccountPersonal;
import com.springboot.adakita.adakita.service.AccountPersonalService;

import com.springboot.adakita.adakita.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AccountPersonalService accountPersonalService;
    private final LoginService loginService;

    @Autowired
    public AdminController(AccountPersonalService accountPersonalService, LoginService loginService) {
        this.accountPersonalService = accountPersonalService;
        this.loginService = loginService;
    }


    @GetMapping("/home")
    public String listAccount(Model theModel) {

        List<AccountPersonal> theAccount = accountPersonalService.getAllUsers();

        theModel.addAttribute("account_personal", theAccount);

        return "admin/homeAdmin";
    }

    @GetMapping("/addaccount")
    public String AddAccount(Model theModel) {

        AccountPersonal theAccount = new AccountPersonal();

        theModel.addAttribute("accountId", theAccount);

        return "/admin/adminAdd";
    }

    @PostMapping("/addaccount")
    public String PostRegisterPersonal(@ModelAttribute("accountId") AccountPersonal account) {
        loginService.addUser(account);
        return "redirect:/admin/home";
    }

    @PostMapping("/updateaccount")
    public String UpdateAccount(@RequestParam("accountId") int theId, Model theModel) {

        AccountPersonal theAccount = accountPersonalService.getAccountById(theId);

        theModel.addAttribute("accountId", theAccount);

        return "/admin/adminForm";
    }

    @PostMapping("/save")
    public String saveAccount(@ModelAttribute("accountId") AccountPersonal theAccount) {

        AccountPersonal existingAccount = accountPersonalService.getAccountById(theAccount.getAccount_id());

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

        return "redirect:/admin/home";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("accountId") int theId) {

        // delete the employee
        accountPersonalService.deleteAccount(theId);

        return "redirect:/admin/home";

    }
}

