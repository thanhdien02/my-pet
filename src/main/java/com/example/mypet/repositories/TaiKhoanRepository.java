package com.example.mypet.repositories;



import com.example.mypet.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaiKhoanRepository extends MongoRepository<TaiKhoan, String> {


    List<TaiKhoan> findByemail(String email);
}
