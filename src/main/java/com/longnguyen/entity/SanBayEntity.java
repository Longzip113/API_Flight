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
@Table(name = "sanbay")
public class SanBayEntity {
	
	@Id // (định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "tenthanhpho")
	private String tenThanhPho;
	
	@Column(name = "tensanbay")
	private String tenSanBay;
	
	@Column(name = "quocgia")
	private String quocGia;
	
	@Column(name = "tinhtrang")
	private Boolean tinhTrang;
	
	@OneToMany(mappedBy = "sanBaydi")
	private List<TuyenBayEntity> tuyenBayEntitiesDi = new ArrayList<>();
	
	@OneToMany(mappedBy = "sanBayDen")
	private List<TuyenBayEntity> tuyenBayEntitiesDen = new ArrayList<>();
	
	

	public List<TuyenBayEntity> getTuyenBayEntitiesDi() {
		return tuyenBayEntitiesDi;
	}

	public void setTuyenBayEntitiesDi(List<TuyenBayEntity> tuyenBayEntitiesDi) {
		this.tuyenBayEntitiesDi = tuyenBayEntitiesDi;
	}

	public List<TuyenBayEntity> getTuyenBayEntitiesDen() {
		return tuyenBayEntitiesDen;
	}

	public void setTuyenBayEntitiesDen(List<TuyenBayEntity> tuyenBayEntitiesDen) {
		this.tuyenBayEntitiesDen = tuyenBayEntitiesDen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTenThanhPho() {
		return tenThanhPho;
	}

	public void setTenThanhPho(String tenThanhPho) {
		this.tenThanhPho = tenThanhPho;
	}

	public String getTenSanBay() {
		return tenSanBay;
	}

	public void setTenSanBay(String tenSanBay) {
		this.tenSanBay = tenSanBay;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
}
