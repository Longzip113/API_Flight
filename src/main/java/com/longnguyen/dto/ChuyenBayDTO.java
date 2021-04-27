package com.longnguyen.dto;

import java.util.Date;

public class ChuyenBayDTO {

	private Long id;
	private Long tuyenBayId;
	private Long mayBayId;
	private Float thoiGianBay;
	private Date ngayGio;
	private Boolean tinhTrang;
	
	
	

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

	public Long getTuyenBayId() {
		return tuyenBayId;
	}

	public void setTuyenBayId(Long tuyenBayId) {
		this.tuyenBayId = tuyenBayId;
	}

	public Long getMayBayId() {
		return mayBayId;
	}

	public void setMayBayId(Long mayBayId) {
		this.mayBayId = mayBayId;
	}	
}
