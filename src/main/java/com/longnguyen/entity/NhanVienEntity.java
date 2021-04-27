package com.longnguyen.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVienEntity {

	@Id // (định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
	private Long id;
	
	@Column(name = "hoten")
	private String hoTen;
	
	@Column(name = "cmnd")
	private String CMND;
	
	@Column(name = "sodienthoai")
	private String soDienThoai;
	
	@Column(name = "taikhoan")
	private String taiKhoan;
	
	@Column(name = "matkhau")
	private String matKhau;
	
	@Column(name = "tinhtrang")
	private Boolean tinhTrang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chucvu_id")
	private ChucVuEntity chucVuEntity;
	
	@OneToMany(mappedBy = "nhanVienEntity")
	private List<PhieuDatVeEntity> phieuDatVeEntities = new ArrayList<>();
	

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

	public ChucVuEntity getChucVuEntity() {
		return chucVuEntity;
	}

	public void setChucVuEntity(ChucVuEntity chucVuEntity) {
		this.chucVuEntity = chucVuEntity;
	}
}
