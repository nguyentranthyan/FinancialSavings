package com.thyan.fisa.entities;

public class TaiKhoan {
    private String email;
    private String matKhau;
    private String hinhAnh;

    public TaiKhoan(String s, String toString) {
    }

    public TaiKhoan(String email, String matKhau, String hinhanh) {
        this.email = email;
        this.matKhau = matKhau;
        this.hinhAnh = hinhanh;
    }
}
