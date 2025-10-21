package com.springboot.adakita.adakita.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_perusahaan")
public class AccountPerusahaan extends Account implements MaksimalPeminjaman{

    @Column(name = "nama_perusahaan")
    private String namaPerusahaan;

    @Column(name = "jenis_usahan")
    private String jenisUsahan;

    @Column(name = "alamat")
    private String alamat;

    public AccountPerusahaan(int account_id, String username,String gmail, String password, String name, int telp_number, int poin, String namaPerusahaan, String jenisUsahan, String alamat) {
        super(account_id, username, gmail, password, name, telp_number, poin);
        this.namaPerusahaan = namaPerusahaan;
        this.jenisUsahan = jenisUsahan;
        this.alamat = alamat;
    }


    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public void setJenisUsahan(String jenisUsahan) {
        this.jenisUsahan = jenisUsahan;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public String getJenisUsahan() {
        return jenisUsahan;
    }

    public String getAlamat() {
        return alamat;
    }

    @Override
    public int maksimalPeminjaman() {
        return 10000000;
    }

    @Override
    public int BatasPeminjamna() {
        return 5;
    }
}