package com.example.mypet.controller;

import com.example.mypet.dtos.DichVuDto;
import com.example.mypet.dtos.LoaiThuCungDto;
import com.example.mypet.entities.DichVu;
import com.example.mypet.entities.LoaiThuCung;
import com.example.mypet.entities.ResponseObject;
import com.example.mypet.repositories.DichVuRepository;
import com.example.mypet.repositories.LoaiThuCungRepository;
import com.example.mypet.services.DichVuService;
import com.example.mypet.services.LoaiThuCungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/loai")
public class LoaiThuCungController {

    @Autowired
    private LoaiThuCungService loaiThuCungService;

    @Autowired
    private LoaiThuCungRepository loaiThuCungRepository;

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insert(@RequestBody LoaiThuCungDto dto) {

        LoaiThuCung loaiThuCung = new LoaiThuCung();
        loaiThuCung.setMaLoaiThuCung(dto.getMaLoaiThuCung());
        loaiThuCung.setTenLoaiThuCung(dto.getTenLoaiThuCung());

        List<LoaiThuCung> foundLoaiThuCung = loaiThuCungRepository.findBymaLoaiThuCung(dto.getMaLoaiThuCung().trim());

        if(foundLoaiThuCung.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Ma loai thu cung da bi trung", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("oke", "them thanh cong", loaiThuCungRepository.save(loaiThuCung)));
    }
    @GetMapping("/all")
    List<LoaiThuCung> getAllLoaiThuCung() {
        return loaiThuCungRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable String id) {

        Optional<LoaiThuCung> loaiThuCung = loaiThuCungService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("oke", "tim kiem thanh cong", loaiThuCung));

    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateLoaiThuCung(@RequestBody LoaiThuCung newLoaiThuCung, @PathVariable String id) {
        LoaiThuCung updateLoaiThuCung = loaiThuCungRepository.findById(id)
                .map(loaiThuCung -> {
                    loaiThuCung.setTenLoaiThuCung(newLoaiThuCung.getTenLoaiThuCung());
                    loaiThuCung.setMaLoaiThuCung(newLoaiThuCung.getMaLoaiThuCung());
                    return loaiThuCungRepository.save(loaiThuCung);
                }).orElseGet(() -> {
                    newLoaiThuCung.setId(id);
                    return loaiThuCungRepository.save(newLoaiThuCung);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update user successfully", updateLoaiThuCung)
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable String id) {
        boolean exists = loaiThuCungRepository.existsById(id);
        if(exists) {
            loaiThuCungRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete LoaiDichVu successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find LoaiDichVu to delete", "")
        );
    }
}
