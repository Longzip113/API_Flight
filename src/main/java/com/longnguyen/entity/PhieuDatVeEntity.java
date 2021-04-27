package com.longnguyen.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phieudatve")
public class PhieuDatVeEntity {

	@Id // (định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
	private Long id;
	
	@Column(name = "ghichu")
	private String ghiChu;
	
	@Column(name = "maghe")
	private String maGhe;
	
	@Column(name = "codePhieuDatVe")
	private String codePhieuDatVe;

	@Column(name = "ngaydat")
	private Date ngayDat;
	
	@Column(name = "thanhtien")
	private Double thanhTien;
	
	@Column(name = "tinhtrang")
	private Boolean tinhTrang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vechuyenbay_id")
	private VeChuyenBayEntity veChuyenBayEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "khachhang_id")
	private KhachHangEntity khachHangEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nhanvien_id")
	private NhanVienEntity nhanVienEntity;

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

	public VeChuyenBayEntity getVeChuyenBayEntity() {
		return veChuyenBayEntity;
	}

	public void setVeChuyenBayEntity(VeChuyenBayEntity veChuyenBayEntity) {
		this.veChuyenBayEntity = veChuyenBayEntity;
	}

	public KhachHangEntity getKhachHangEntity() {
		return khachHangEntity;
	}

	public void setKhachHangEntity(KhachHangEntity khachHangEntity) {
		this.khachHangEntity = khachHangEntity;
	}

	public NhanVienEntity getNhanVienEntity() {
		return nhanVienEntity;
	}

	public void setNhanVienEntity(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
	}
}
