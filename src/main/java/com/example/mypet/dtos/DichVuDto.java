package com.example.mypet.dtos;

import com.example.mypet.entities.embedded.GiaDichVu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DichVuDto {
    @Id
    private String id;

    // mã dịch vụ không được trùng
    private String maDichVu;


    private String tenDichVu;

    // nội dung là html
    private String noiDung;

    // Giá dịch vụ phụ thuộc vào loại thú cưng và cân nặng của thú cưng
    private List<GiaDichVu> giaDichVus = new ArrayList<>();

    private boolean trangThai = true;
}
