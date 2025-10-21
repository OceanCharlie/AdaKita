package com.springboot.adakita.adakita.controller;

import com.springboot.adakita.adakita.entity.AccountPersonal;
import com.springboot.adakita.adakita.entity.AccountPerusahaan;
import com.springboot.adakita.adakita.entity.Pinjaman;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.springboot.adakita.adakita.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login/auth")
    public String Login(Principal principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        return "/login/sign-in";
    }

    @GetMapping("/register")
    public String Register() {
        return "/login/sign-up";
    }

    @GetMapping("/register/personal")
    public String RegisterPersonal(Model theModel) {
        theModel.addAttribute("accountId", new AccountPersonal());
        return "/login/sign-up-personal";
    }

    @PostMapping("/register/personal")
    public String PostRegisterPersonal(@ModelAttribute("accountId") AccountPersonal account) {
        loginService.addUser(account);
        return "redirect:/login/sign-up-personal";
    }
}
