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
@Table(name = "hangve")
public class HangVeEntity {
	
	@Id //(định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id tự động tăng
	private Long id;  
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "tenhangve")
	private String tenHangVe;
	
	@Column(name = "tinhtrang")
	private Boolean tinhTrang;
	
	@OneToMany(mappedBy = "hangVeEntity")
	private List<VeChuyenBayEntity> veChuyenBayEntities = new ArrayList<>();
	
	
	public List<VeChuyenBayEntity> getVeChuyenBayEntities() {
		return veChuyenBayEntities;
	}

	public void setVeChuyenBayEntities(List<VeChuyenBayEntity> veChuyenBayEntities) {
		this.veChuyenBayEntities = veChuyenBayEntities;
	}

	public String getTenHangVe() {
		return tenHangVe;
	}

	public void setTenHangVe(String tenHangVe) {
		this.tenHangVe = tenHangVe;
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


	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	
	
	
}
