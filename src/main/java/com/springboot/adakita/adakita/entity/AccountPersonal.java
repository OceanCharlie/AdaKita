package com.springboot.adakita.adakita.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "account_personal")
public class AccountPersonal extends Account implements MaksimalPeminjaman{

    @Column(name = "date_of_birth")
    private LocalDate date;

    @Column(name = "pendidikan")
    private String pendidikan;

    @Column(name = "pekerjaan")
    private String pekerjaan;

    @Column(name = "ktp")
    private String ktp;

    public AccountPersonal() {}

    public AccountPersonal(int account_id, String username, String gmail, String password, String name, int telp_number, int poin, LocalDate date, String pendidikan, String pekerjaan, String ktp) {
        super(account_id, username, gmail, password, name, telp_number, poin);
        this.date = date;
        this.pendidikan = pendidikan;
        this.pekerjaan = pekerjaan;
        this.ktp = ktp;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public String getKtp() {
        return ktp;
    }

    @Override
    public int maksimalPeminjaman() {
        return 5000000;
    }

    @Override
    public int BatasPeminjamna() {
        return 5;
    }
}