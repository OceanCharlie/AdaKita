package com.springboot.adakita.adakita.entity;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "account")
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int account_id;

    @Column(name = "username")
    private String username;

    @Column(name = "gmail")
    private String gmail;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "nik")
    private int nik;

    @Column(name = "telp_number")
    private int telp_number;

    @Column(name = "amount_transaction")
    private int amountTransaction;

    public Account(int account_id, String username, String gmail, String password, String name, int telp_number, int nik) {
        this.account_id = account_id;
        this.username = username;
        this.gmail = gmail;
        this.password = password;
        this.name = name;
        this.nik = nik;
        this.telp_number = telp_number;
    }

    public Account() {}

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNik(int nik) {
        this.nik = nik;
    }

    public void setTelp_number(int telp_number) {
        this.telp_number = telp_number;
    }

    public void setAmountTransaction(int amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public int getAccount_id() {
        return account_id;
    }

    public String getUsername() {
        return username;
    }

    public String getGmail() {
        return gmail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getNik() {
        return nik;
    }

    public int getTelp_number() {
        return telp_number;
    }

    public int getAmountTransaction() {
        return amountTransaction;
    }

    public abstract int BatasPeminjamna();
}