package com.example.mypet.repositories;

import com.example.mypet.entities.DichVu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DichVuRepository extends MongoRepository<DichVu, String> {

    List<DichVu> findBymaDichVu(String maDichVu);
}
