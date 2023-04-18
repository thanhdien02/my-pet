package com.example.mypet.services.Imp;

import com.example.mypet.entities.DichVu;
import com.example.mypet.repositories.DichVuRepository;
import com.example.mypet.services.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DichVuServiceImp implements DichVuService {

    @Autowired
    private DichVuRepository dichVuRepository;
    @Override
    public Optional<DichVu> findById(String Id) {

        return dichVuRepository.findById(Id);
    }

    @Override
    public List<DichVu> findAll() {
        return null;
    }
}
