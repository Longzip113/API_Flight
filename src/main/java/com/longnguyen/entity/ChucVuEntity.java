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
@Table(name = "chucvu")
public class ChucVuEntity {
	
	@Id //(định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id tự động tăng
	private Long id;  
	
	@Column
	private String code;
	
	@Column(name = "tenchucvu")
	private String tenChucVu;
	
	@Column(name = "tinhtrang")
	private Boolean tinhTrang;
	
	@OneToMany(mappedBy = "chucVuEntity")
	private List<NhanVienEntity> nhanVienEntities = new ArrayList<>();

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

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public List<NhanVienEntity> getNews() {
		return nhanVienEntities;
	}

	public void setNews(List<NhanVienEntity> nhanVienEntities) {
		this.nhanVienEntities = nhanVienEntities;
	}
}
