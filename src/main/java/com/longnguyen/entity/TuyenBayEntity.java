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
@Table(name = "tuyenbay")
public class TuyenBayEntity {

	@Id // (định nghia khoa chinh va not null)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
	private Long id;
	
	@Column(name = "tinhtrang")
	private Boolean tinhTrang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sanbaydi_id")
	private SanBayEntity sanBaydi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sanbayden_id")
	private SanBayEntity sanBayDen;
	
	@OneToMany(mappedBy = "tuyenBayEntity")
	private List<ChuyenBayEntity> chuyenBayEntityies = new ArrayList<>();

	
	

	public List<ChuyenBayEntity> getChuyenBayEntityies() {
		return chuyenBayEntityies;
	}

	public void setChuyenBayEntityies(List<ChuyenBayEntity> chuyenBayEntityies) {
		this.chuyenBayEntityies = chuyenBayEntityies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public SanBayEntity getSanBaydi() {
		return sanBaydi;
	}

	public void setSanBaydi(SanBayEntity sanBaydi) {
		this.sanBaydi = sanBaydi;
	}

	public SanBayEntity getSanBayDen() {
		return sanBayDen;
	}

	public void setSanBayDen(SanBayEntity sanBayDen) {
		this.sanBayDen = sanBayDen;
	}
	
	
}
