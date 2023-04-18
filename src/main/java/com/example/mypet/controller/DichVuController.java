package com.example.mypet.controller;

import com.example.mypet.dtos.DichVuDto;
import com.example.mypet.dtos.TaiKhoanDto;
import com.example.mypet.entities.DichVu;
import com.example.mypet.entities.ResponseObject;
import com.example.mypet.entities.TaiKhoan;
import com.example.mypet.repositories.DichVuRepository;
import com.example.mypet.repositories.TaiKhoanRepository;
import com.example.mypet.services.DichVuService;
import com.example.mypet.services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dichvu")
public class DichVuController {

    @Autowired
    private DichVuService dichVuService;

    @Autowired
    private DichVuRepository dichVuRepository;

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insert(@RequestBody DichVuDto dto) {

        DichVu dichVu = new DichVu();
        dichVu.setMaDichVu(dto.getMaDichVu());
        dichVu.setTenDichVu(dto.getTenDichVu());
        dichVu.setNoiDung(dto.getNoiDung());
        dichVu.setGiaDichVus(dto.getGiaDichVus());

        List<DichVu> foundDichVu = dichVuRepository.findBymaDichVu(dto.getMaDichVu().trim());

        if(foundDichVu.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Ma dich vu da bi trung", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("oke", "them thanh cong", dichVuRepository.save(dichVu)));
    }
    @GetMapping("/all")
    List<DichVu> getAllDichVu() {
        return dichVuRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable String id) {

        Optional<DichVu> dichVu = dichVuService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("oke", "tim kiem thanh cong", dichVu));

    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateDichVu(@RequestBody DichVu newDichVu, @PathVariable String id) {
        DichVu updateDichVu = dichVuRepository.findById(id)
                .map(dichVu -> {
                    dichVu.setTenDichVu(newDichVu.getTenDichVu());
                    dichVu.setNoiDung(newDichVu.getNoiDung());
                    dichVu.setGiaDichVus(newDichVu.getGiaDichVus());
                    dichVu.setMaDichVu(newDichVu.getMaDichVu());
                    return dichVuRepository.save(dichVu);
                }).orElseGet(() -> {
                    newDichVu.setId(id);
                    return dichVuRepository.save(newDichVu);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update user successfully", updateDichVu)
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteDichVu(@PathVariable String id) {
        boolean exists = dichVuRepository.existsById(id);
        if(exists) {
            dichVuRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete DichVu successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find DichVu to delete", "")
        );
    }
}
