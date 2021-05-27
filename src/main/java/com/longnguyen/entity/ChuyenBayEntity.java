package com.longnguyen.entity;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "chuyenbay")
public class ChuyenBayEntity {

	@Id // (định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
	private Long id;
	
	@Column(name = "thoigianbay")
	private Float thoiGianBay;
	
	@Column(name = "ghephothong")
	private Integer ghePhoThong;
	
	@Column(name = "ghethuonggia")
	private Integer gheThuongGia;
	
	@Column(name = "gio")
	private String gio;

	public String getGio() {
		return gio;
	}

	public void setGio(String gio) {
		this.gio = gio;
	}

	@Column(name = "ngaygio")
	private Date ngayGio;
	
	@Column(name = "tinhtrang")
	private Boolean tinhTrang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tuyenbay_id")
	private TuyenBayEntity tuyenBayEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maybay_id")
	private MayBayEntity mayBayEntity;
	
	@OneToMany(mappedBy = "chuyenBayEntity")
	private List<VeChuyenBayEntity> veChuyenBayEntities = new ArrayList<>();

	public List<VeChuyenBayEntity> getVeChuyenBayEntities() {
		return veChuyenBayEntities;
	}

	public void setVeChuyenBayEntities(List<VeChuyenBayEntity> veChuyenBayEntities) {
		this.veChuyenBayEntities = veChuyenBayEntities;
	}
	
	public Integer getGhePhoThong() {
		return ghePhoThong;
	}

	public void setGhePhoThong(Integer ghePhoThong) {
		this.ghePhoThong = ghePhoThong;
	}

	public Integer getGheThuongGia() {
		return gheThuongGia;
	}

	public void setGheThuongGia(Integer gheThuongGia) {
		this.gheThuongGia = gheThuongGia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getThoiGianBay() {
		return thoiGianBay;
	}

	public void setThoiGianBay(Float thoiGianBay) {
		this.thoiGianBay = thoiGianBay;
	}

	public Date getNgayGio() {
		return ngayGio;
	}

	public void setNgayGio(Date ngayGio) {
		this.ngayGio = ngayGio;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public TuyenBayEntity getTuyenBayEntity() {
		return tuyenBayEntity;
	}

	public void setTuyenBayEntity(TuyenBayEntity tuyenBayEntity) {
		this.tuyenBayEntity = tuyenBayEntity;
	}

	public MayBayEntity getMayBayEntity() {
		return mayBayEntity;
	}

	public void setMayBayEntity(MayBayEntity mayBayEntity) {
		this.mayBayEntity = mayBayEntity;
	}
	
	
}
