package com.springboot.adakita.adakita.controller;

import com.springboot.adakita.adakita.entity.AccountPersonal;
import com.springboot.adakita.adakita.entity.Pinjaman;
import com.springboot.adakita.adakita.service.AccountPersonalService;
import com.springboot.adakita.adakita.service.PinjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class PinjamanController {

    private final PinjamanService pinjamanService;
    private final AccountPersonalService accountPersonalService;

    @Autowired
    public PinjamanController(PinjamanService pinjamanService, AccountPersonalService accountPersonalService) {
        this.pinjamanService = pinjamanService;
        this.accountPersonalService = accountPersonalService;
    }

    public AccountPersonal getAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        String username = user.getUsername();

        AccountPersonal logedInAccount = accountPersonalService.getAccountByUsername(username);

        return logedInAccount;
    }

    @GetMapping("/pinjaman")
    public String Pinjaman() {
        return "pinjaman/peminjaman-personal";
    }

    @GetMapping("/history")
    public String History( Model theModel) {

        List<Pinjaman> pinjaman = pinjamanService.getAllpinjamanById(Collections.singletonList(getAccount().getAccount_id()));

        theModel.addAttribute("history_pinjaman", pinjaman);

        return "/history/history-personal";
    }

    @GetMapping("/addpinjaman")
    public String AddPinjaman(Model theModel) {
        theModel.addAttribute("pinjaman", new Pinjaman());
        return "/pinjaman/peminjaman-personal";
    }

    @PostMapping("/addpinjaman")
    public String savePinjaman(@ModelAttribute("pinjaman") Pinjaman pinjaman) {

        pinjaman.setAccountId(getAccount().getAccount_id());
        pinjaman.setJumlahPengembalian((int) (pinjaman.getJumlahPinjaman() * 1.05));
        pinjaman.setTanggalPengembalian(pinjaman.getTanggalPinjaman().plusMonths(3));
        pinjamanService.addPinjaman(pinjaman);

        return "redirect:/history";
    }
}
