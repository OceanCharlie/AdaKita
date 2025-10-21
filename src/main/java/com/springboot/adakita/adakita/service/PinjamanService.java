package com.springboot.adakita.adakita.service;

import com.springboot.adakita.adakita.entity.Account;
import com.springboot.adakita.adakita.entity.AccountPerusahaan;
import com.springboot.adakita.adakita.entity.Pinjaman;
import com.springboot.adakita.adakita.repository.AccountPerusahaanRepository;
import com.springboot.adakita.adakita.repository.PinjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PinjamanService {
    @Autowired
    PinjamanRepository pinjamanRepository;

    public List<Pinjaman> getAllPinjaman() {
        return pinjamanRepository.findAll();
    }

    public List<Pinjaman> getAllpinjamanById(List<Integer> id) {

        List<Pinjaman> allPinjaman = pinjamanRepository.findAll();

        return allPinjaman.stream()
                .filter(pinjaman -> id.contains(pinjaman.getAccount_id()))
                .collect(Collectors.toList());
    }

    public Pinjaman addPinjaman(Pinjaman pinjaman) {
        return pinjamanRepository.save(pinjaman);
    }

    public Pinjaman updatePinjaman(int pinjaman_id, Pinjaman pinjaman) {
        pinjaman.setPinjaman_id(pinjaman_id);
        return pinjamanRepository.save(pinjaman);
    }

    public void deletePinjaman(int pinjamna_id) {
        pinjamanRepository.deleteById(pinjamna_id);
    }

    public void save(Pinjaman pinjaman) {
        pinjamanRepository.save(pinjaman);
    }
}
