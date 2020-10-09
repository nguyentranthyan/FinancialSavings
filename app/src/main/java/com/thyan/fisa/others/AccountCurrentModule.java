//package com.thyan.fisa.others;
//
//import com.iuh.fisa.entities.SinhVien;
//import com.iuh.fisa.entities.TaiKhoan;
//import com.iuh.fisa.helper.DBHelper;
//
//public class AccountCurrentModule {
//
//    public static SinhVien getSinhVienCurrent(DBHelper dbHelper) {
//        TaiKhoan taiKhoan = dbHelper.getByCode_TaiKhoan(1);
//        return dbHelper.getByID_SinhVien(taiKhoan.getEmail());
//    }
//}
