package com.example.mypet.services;



import com.example.mypet.entities.TaiKhoan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaiKhoanService {

    TaiKhoan insert(TaiKhoan taiKhoan);

    List<TaiKhoan> findAll();

    Optional<TaiKhoan> findById(String Id);
}
