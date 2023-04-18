package com.example.mypet.services;

import com.example.mypet.entities.DichVu;
import com.example.mypet.entities.LoaiThuCung;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LoaiThuCungService {

    List<LoaiThuCung> findAll();

    Optional<LoaiThuCung> findById(String Id);

}
