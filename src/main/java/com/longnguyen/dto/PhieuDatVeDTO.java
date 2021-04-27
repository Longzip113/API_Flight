package com.longnguyen.dto;

import java.util.Date;

public class PhieuDatVeDTO {

	private Long id;
	private Long vechuyenbayID;
	private Long khachHangID;
	private Long nhanVienID;
	private String ghiChu;
	private String maGhe;
	private String codePhieuDatVe;
	private Date ngayDat;
	private Double thanhTien;
	private Boolean tinhTrang;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getMaGhe() {
		return maGhe;
	}

	public void setMaGhe(String maGhe) {
		this.maGhe = maGhe;
	}

	public String getCodePhieuDatVe() {
		return codePhieuDatVe;
	}

	public void setCodePhieuDatVe(String codePhieuDatVe) {
		this.codePhieuDatVe = codePhieuDatVe;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(Double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Long getVechuyenbayID() {
		return vechuyenbayID;
	}

	public void setVechuyenbayID(Long vechuyenbayID) {
		this.vechuyenbayID = vechuyenbayID;
	}

	public Long getKhachHangID() {
		return khachHangID;
	}

	public void setKhachHangID(Long khachHangID) {
		this.khachHangID = khachHangID;
	}

	public Long getNhanVienID() {
		return nhanVienID;
	}

	public void setNhanVienID(Long nhanVienID) {
		this.nhanVienID = nhanVienID;
	}

}
