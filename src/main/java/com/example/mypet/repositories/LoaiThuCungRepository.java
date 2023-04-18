package com.example.mypet.repositories;

import com.example.mypet.entities.LoaiThuCung;
import com.example.mypet.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LoaiThuCungRepository extends MongoRepository<LoaiThuCung, String> {

    List<LoaiThuCung> findBymaLoaiThuCung(String maLoaiThuCung);
}
