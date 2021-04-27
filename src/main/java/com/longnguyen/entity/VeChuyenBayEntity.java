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
@Table(name = "vechuyenbay")
public class VeChuyenBayEntity {

	@Id // (định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
	private Long id;
	
	@Column(name = "dongia")
	private Float donGia;
	
	@Column(name = "tinhtrang")
	private Boolean tinhTrang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chuyenbay_id")
	private ChuyenBayEntity chuyenBayEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hangve_id")
	private HangVeEntity hangVeEntity;
	
	@OneToMany(mappedBy = "veChuyenBayEntity")
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

	public Float getDonGia() {
		return donGia;
	}

	public void setDonGia(Float donGia) {
		this.donGia = donGia;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public ChuyenBayEntity getChuyenBayEntity() {
		return chuyenBayEntity;
	}

	public void setChuyenBayEntity(ChuyenBayEntity chuyenBayEntity) {
		this.chuyenBayEntity = chuyenBayEntity;
	}

	public HangVeEntity getHangVeEntity() {
		return hangVeEntity;
	}

	public void setHangVeEntity(HangVeEntity hangVeEntity) {
		this.hangVeEntity = hangVeEntity;
	}
}
