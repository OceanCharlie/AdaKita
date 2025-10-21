package com.springboot.adakita.adakita.controller;

import com.springboot.adakita.adakita.entity.AccountPersonal;
import com.springboot.adakita.adakita.entity.AccountPerusahaan;
import com.springboot.adakita.adakita.service.AccountPersonalService;
import com.springboot.adakita.adakita.service.AccountPerusahaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final AccountPersonalService accountPersonalService;

    @Autowired
    public HomeController(AccountPersonalService accountPersonalService, AccountPerusahaanService accountPerusahaanService) {
        this.accountPersonalService = accountPersonalService;
    }

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String LoginAuth(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isLogin = authentication != null && authentication.isAuthenticated() &&
                        !(authentication.getPrincipal() instanceof String &&
                        authentication.getPrincipal().equals("anonymousUser"));
        model.addAttribute("isLogin", isLogin);
        return "index";
    }
}
