package com.thyan.fisa.entities;

import java.sql.Date;

public class SoGiaoDich {
    private String maGiaoDich;
    private double soTien;
    private String ghiChu;
    private Date ngayGiaoDich;

    private String masv;
    private String maSuKien;
    private String maDanhMuc;
    private String maTietKiem;
    private String maVi;

    private int status;
    private String nhacNho;
    private String lapLai;
    private String gioGiaoDich;


    public SoGiaoDich() {
    }

    public SoGiaoDich(String maGiaoDich, double soTien, String ghiChu, Date ngayGiaoDich, String masv, String maSuKien,
                      String maDanhMuc, String maTietKiem, String maVi, int status, String nhacNho, String lapLai, String gioGiaoDich) {
        this.maGiaoDich = maGiaoDich;
        this.soTien = soTien;
        this.ghiChu = ghiChu;
        this.ngayGiaoDich = ngayGiaoDich;
        this.masv = masv;
        this.maSuKien = maSuKien;
        this.maDanhMuc = maDanhMuc;
        this.maTietKiem = maTietKiem;
        this.maVi = maVi;
        this.status = status;
        this.nhacNho = nhacNho;
        this.lapLai = lapLai;
        this.gioGiaoDich = gioGiaoDich;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getMaSuKien() {
        return maSuKien;
    }

    public void setMaSuKien(String maSuKien) {
        this.maSuKien = maSuKien;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getMaTietKiem() {
        return maTietKiem;
    }

    public void setMaTietKiem(String maTietKiem) {
        this.maTietKiem = maTietKiem;
    }

    public String getMaVi() {
        return maVi;
    }

    public void setMaVi(String maVi) {
        this.maVi = maVi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNhacNho() {
        return nhacNho;
    }

    public void setNhacNho(String nhacNho) {
        this.nhacNho = nhacNho;
    }

    public String getLapLai() {
        return lapLai;
    }

    public void setLapLai(String lapLai) {
        this.lapLai = lapLai;
    }

    public String getGioGiaoDich() {
        return gioGiaoDich;
    }

    public void setGioGiaoDich(String gioGiaoDich) {
        this.gioGiaoDich = gioGiaoDich;
    }

    @Override
    public String toString() {
        return "SoGiaoDich{" +
                "maGiaoDich='" + maGiaoDich + '\'' +
                ", soTien=" + soTien +
                ", ghiChu='" + ghiChu + '\'' +
                ", ngayGiaoDich=" + ngayGiaoDich +
                ", masv='" + masv + '\'' +
                ", maSuKien='" + maSuKien + '\'' +
                ", maDanhMuc='" + maDanhMuc + '\'' +
                ", maTietKiem='" + maTietKiem + '\'' +
                ", maVi='" + maVi + '\'' +
                ", status=" + status +
                ", nhacNho='" + nhacNho + '\'' +
                ", lapLai='" + lapLai + '\'' +
                ", gioGiaoDich='" + gioGiaoDich + '\'' +
                '}';
    }

    public String toStringAnother() {
        return "SoGiaoDich{" +
                "soTien=" + soTien +
                ", ghiChu='" + ghiChu + '\'' +
                ", masv='" + masv + '\'' +
                ", maSuKien='" + maSuKien + '\'' +
                ", maDanhMuc='" + maDanhMuc + '\'' +
                ", maTietKiem='" + maTietKiem + '\'' +
                ", maVi='" + maVi + '\'' +
                ", status=" + status +
                '}';
    }

    public String toStringRecommendFast() {
        return "SoGiaoDich{" +
                "soTien=" + soTien +
                ", ghiChu='" + ghiChu + '\'' +
                ", masv='" + masv + '\'' +
                ", maSuKien='" + maSuKien + '\'' +
                ", maDanhMuc='" + maDanhMuc + '\'' +
                ", maTietKiem='" + maTietKiem + '\'' +
                ", maVi='" + maVi + '\'' +
                '}';
    }
}
