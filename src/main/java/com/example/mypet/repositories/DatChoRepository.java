package com.example.mypet.repositories;

import com.example.mypet.entities.DatCho;
import com.example.mypet.entities.LoaiThuCung;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DatChoRepository extends MongoRepository<DatCho, String> {

    List<DatCho> findByemail(String email);
}
