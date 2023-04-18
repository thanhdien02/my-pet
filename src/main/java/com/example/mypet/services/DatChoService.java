package com.example.mypet.services;

import com.example.mypet.entities.DatCho;
import com.example.mypet.entities.TaiKhoan;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DatChoService {

    Optional<DatCho> findById(String Id);
}
