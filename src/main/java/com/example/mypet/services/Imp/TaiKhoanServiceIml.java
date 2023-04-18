package com.example.mypet.services.Imp;


import com.example.mypet.entities.TaiKhoan;
import com.example.mypet.repositories.TaiKhoanRepository;
import com.example.mypet.services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanServiceIml implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public TaiKhoan insert(TaiKhoan taiKhoan) {

        return taiKhoanRepository.insert(taiKhoan);
    }
    @Override
    public List<TaiKhoan> findAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public Optional<TaiKhoan> findById(String Id) {

        return taiKhoanRepository.findById(Id);
    }
}
