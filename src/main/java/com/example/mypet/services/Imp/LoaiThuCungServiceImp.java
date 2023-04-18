package com.example.mypet.services.Imp;

import com.example.mypet.entities.DichVu;
import com.example.mypet.entities.LoaiThuCung;
import com.example.mypet.repositories.LoaiThuCungRepository;
import com.example.mypet.services.LoaiThuCungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiThuCungServiceImp implements LoaiThuCungService {

    @Autowired
    private LoaiThuCungRepository loaiThuCungRepository;

    @Override
    public List<LoaiThuCung> findAll() {
        return null;
    }

    @Override
    public Optional<LoaiThuCung> findById(String Id) {

        return loaiThuCungRepository.findById(Id);
    }
}
