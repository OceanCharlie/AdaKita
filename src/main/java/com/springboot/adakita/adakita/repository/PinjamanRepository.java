package com.springboot.adakita.adakita.repository;

import com.springboot.adakita.adakita.entity.Pinjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinjamanRepository extends JpaRepository<Pinjaman, Integer> {
}
