package com.longnguyen.dto;

import java.util.Date;

public class PhieuDatVeDTO {

	private Long id;
	private Long vechuyenbayID;
	private Long khachHangID;
	private Long nhanVienID;
	private String ghiChu;
	private String maVe;
	private Integer roleDatVe;
	private Date ngayDat;
	private Double thanhTien;
	private Boolean tinhTrang;
	private Integer nguoiDatVe_id;
	
	
	private String hoTen;
	private String cmnd;
	private String soDienThoai;
	private String email;
	

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

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maGhe) {
		this.maVe = maGhe;
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

	public Integer getRoleDatVe() {
		return roleDatVe;
	}

	public void setRoleDatVe(Integer roleDatVe) {
		this.roleDatVe = roleDatVe;
	}

	public Integer getNguoiDatVe_id() {
		return nguoiDatVe_id;
	}

	public void setNguoiDatVe_id(Integer nguoiDatVe_id) {
		this.nguoiDatVe_id = nguoiDatVe_id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getCMND() {
		return cmnd;
	}

	public void setCMND(String cMND) {
		cmnd = cMND;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
