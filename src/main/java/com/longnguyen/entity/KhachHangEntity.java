package com.longnguyen.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHangEntity {

	@Id // (định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
	private Long id;
	
	@Column(name = "hoten")
	private String hoTen;
	
	@Column(name = "cmnd")
	private String CMND;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "sodienthoai")
	private String soDienThoai;
	
	@Column(name = "taikhoan")
	private String taiKhoan;
	
	@Column(name = "matkhau")
	private String matKhau;
	
	@Column(name = "tinhtrang")
	private Boolean tinhTrang;
	
	@OneToMany(mappedBy = "khachHangEntity")
	private List<PhieuDatVeEntity> phieuDatVeEntities = new ArrayList<>();
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PhieuDatVeEntity> getPhieuDatVeEntities() {
		return phieuDatVeEntities;
	}

	public void setPhieuDatVeEntities(List<PhieuDatVeEntity> phieuDatVeEntities) {
		this.phieuDatVeEntities = phieuDatVeEntities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
}
