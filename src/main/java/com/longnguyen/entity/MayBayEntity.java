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
@Table(name = "maybay")
public class MayBayEntity {
	
	@Id // (định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
	private Long id;
	
	@Column(name = "tenmaybay")
	private String tenMayBay;
	
	@Column(name = "soghehang1")
	private Integer soGheHang1;
	
	@Column(name = "soghehang2")
	private Integer soGheHang2;
	
	@Column(name = "hangmaybay")
	private String hangMayBay;
	
	public String getHangMayBay() {
		return hangMayBay;
	}

	public void setHangMayBay(String hangMayBay) {
		this.hangMayBay = hangMayBay;
	}

	@Column(name = "tinhtrang")
	private Boolean tinhTrang;
	
	@OneToMany(mappedBy = "mayBayEntity")
	private List<ChuyenBayEntity> chuyenBayEntities = new ArrayList<>();
	

	public List<ChuyenBayEntity> getChuyenBayEntities() {
		return chuyenBayEntities;
	}

	public void setChuyenBayEntities(List<ChuyenBayEntity> chuyenBayEntities) {
		this.chuyenBayEntities = chuyenBayEntities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenMayBay() {
		return tenMayBay;
	}

	public void setTenMayBay(String tenMayBay) {
		this.tenMayBay = tenMayBay;
	}

	public Integer getSoGheHang1() {
		return soGheHang1;
	}

	public void setSoGheHang1(Integer soGheHang1) {
		this.soGheHang1 = soGheHang1;
	}

	public Integer getSoGheHang2() {
		return soGheHang2;
	}

	public void setSoGheHang2(Integer soGheHang2) {
		this.soGheHang2 = soGheHang2;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
}
