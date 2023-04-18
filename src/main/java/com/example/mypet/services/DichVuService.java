package com.example.mypet.services;

import com.example.mypet.entities.DichVu;
import com.example.mypet.entities.TaiKhoan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DichVuService {

    Optional<DichVu> findById(String Id);

    List<DichVu> findAll();

}
