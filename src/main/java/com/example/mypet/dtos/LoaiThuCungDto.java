package com.example.mypet.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoaiThuCungDto {

    @Id
    private String id;

    // mã không được trùng
    private String maLoaiThuCung;


    private String tenLoaiThuCung;

    private boolean trangThai = true;
}
