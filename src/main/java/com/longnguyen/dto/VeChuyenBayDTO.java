package com.longnguyen.dto;

public class VeChuyenBayDTO {

	private Long id;
	private Long hangVeID;
	private Long chuyenBayID;
	private Float donGia;
	private Boolean tinhTrang;
	
	private String codeHangVe;
	
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

	public Long getHangVeID() {
		return hangVeID;
	}

	public void setHangVeID(Long hangVeID) {
		this.hangVeID = hangVeID;
	}

	public Long getChuyenBayID() {
		return chuyenBayID;
	}

	public void setChuyenBayID(Long chuyenBayID) {
		this.chuyenBayID = chuyenBayID;
	}

	public String getCodeHangVe() {
		return codeHangVe;
	}

	public void setCodeHangVe(String codeHangVe) {
		this.codeHangVe = codeHangVe;
	}
}
