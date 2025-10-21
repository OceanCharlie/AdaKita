package com.springboot.adakita.adakita.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "pinjaman")
public class Pinjaman {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pinjaman_id;

    @Column(name = "account_id", nullable = false, updatable = false)
    private int account_id;

    @Column(name = "jumlah_pinjaman")
    private int jumlahPinjaman;

    @Column(name = "tujuan_peminjaman")
    private String tujuanPeminjaman;

    @Column(name = "tanggal_pinjaman")
    private LocalDate tanggalPinjaman;

    @Column(name = "jumlah_pengembalian", updatable = false)
    private int jumlahPengembalian;

    @Column(name = "tanggal_pengembalian")
    private LocalDate tanggalPengembalian;

    public Pinjaman(int pinjaman_id, int accountId, int jumlahPinjaman,String tujuanPeminjaman, LocalDate tanggalPinjaman, int jumlahPengembalian, LocalDate tanggalpengembalian) {
        this.pinjaman_id = pinjaman_id;
        this.account_id = accountId;
        this.jumlahPinjaman = jumlahPinjaman;
        this.tujuanPeminjaman = tujuanPeminjaman;
        this.tanggalPinjaman = tanggalPinjaman;
        this.jumlahPengembalian = jumlahPengembalian;
        this.tanggalPengembalian = tanggalpengembalian;
    }

    public Pinjaman(){}

    public void setPinjaman_id(int pinjaman_id) {
        this.pinjaman_id = pinjaman_id;
    }

    public void setAccountId(int accountId) {
        this.account_id = accountId;
    }

    public void setJumlahPinjaman(int jumlahPinjaman) {
        this.jumlahPinjaman = jumlahPinjaman;
    }

    public void setTujuanPeminjaman(String tujuanPeminjaman) {
        this.tujuanPeminjaman = tujuanPeminjaman;
    }

    public void setTanggalPinjaman(LocalDate tanggalPinjaman) {
        this.tanggalPinjaman = tanggalPinjaman;
    }

    public void setJumlahPengembalian(int jumlahPengembalian) {
        this.jumlahPengembalian = jumlahPengembalian;
    }

    public void setTanggalPengembalian(LocalDate tanggaPengembalian) {
        this.tanggalPengembalian = tanggaPengembalian;
    }

    public int getPinjaman_id() {
        return pinjaman_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public int getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public String getTujuanPeminjaman() {
        return tujuanPeminjaman;
    }

    public LocalDate getTanggalPinjaman() {
        return tanggalPinjaman;
    }

    public int getJumlahPengembalian() {
        return jumlahPengembalian;
    }

    public LocalDate getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public String getTanggalPinjamanFormatted() {
        if (tanggalPinjaman != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return tanggalPinjaman.format(formatter);
        }
        return "";  // Return an empty string or a default value if the date is null
    }

    public String getTanggalPengembalianFormatted() {
        if (tanggalPengembalian != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return tanggalPengembalian.format(formatter);
        }
        return "";  // Return an empty string or a default value if the date is null
    }
}
