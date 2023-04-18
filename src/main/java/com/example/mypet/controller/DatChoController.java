package com.example.mypet.controller;

import com.example.mypet.dtos.DatChoDto;
import com.example.mypet.entities.DatCho;
import com.example.mypet.entities.ResponseObject;
import com.example.mypet.repositories.DatChoRepository;
import com.example.mypet.services.DatChoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/datcho")
public class DatChoController {

    @Autowired
    private DatChoService datChoService;

    @Autowired
    private DatChoRepository datChoRepository;

    @GetMapping("/all")
    List<DatCho> getAllDatCho() {
        return datChoRepository.findAll();
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insert(@RequestBody DatChoDto dto) {

        DatCho datCho = new DatCho();
        datCho.setThongTinDatChos(dto.getThongTinDatChos());
        datCho.setTrangThaiDatCho(dto.getTrangThaiDatCho());
        datCho.setEmail(dto.getEmail());
        datCho.setThoiGian(dto.getThoiGian());
        datCho.setCanDan(dto.getCanDan());


        List<DatCho> foundDichVu = datChoRepository.findByemail(dto.getEmail().trim());

        if(foundDichVu.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Email da bi trung", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("oke", "them thanh cong", datChoRepository.save(datCho)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable String id) {

        Optional<DatCho> datCho = datChoService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("oke", "tim kiem thanh cong", datCho));

    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateDatCho(@RequestBody DatCho newDatCho, @PathVariable String id) {
        DatCho updateDatCho = datChoRepository.findById(id)
                .map(datCho -> {
                    datCho.setCanDan(newDatCho.getCanDan());
                    datCho.setEmail(newDatCho.getEmail());
                    datCho.setThongTinDatChos(newDatCho.getThongTinDatChos());
                    datCho.setThoiGian(newDatCho.getThoiGian());
                    datCho.setTrangThaiDatCho(newDatCho.getTrangThaiDatCho());
                    return datChoRepository.save(datCho);
                }).orElseGet(() -> {
                    newDatCho.setId(id);
                    return datChoRepository.save(newDatCho);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Cap nhap Dat Cho thanh cong", updateDatCho)
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteDatCho(@PathVariable String id) {
        boolean exists = datChoRepository.existsById(id);
        if(exists) {
            datChoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Xoa dat cho thanh cong", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Khong tim thay de xoa", "")
        );
    }
}
