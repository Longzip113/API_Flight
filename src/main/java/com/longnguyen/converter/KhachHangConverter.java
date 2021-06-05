package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.KhachHangDTO;
import com.longnguyen.entity.KhachHangEntity;

@Component
public class KhachHangConverter {
	
	public KhachHangEntity toEntity(KhachHangDTO dto) {
		KhachHangEntity entity = new KhachHangEntity();
		
		entity.setId(dto.getId());
		
		entity.setCMND(dto.getCMND());
		entity.setHoTen(dto.getHoTen());
		entity.setEmail(dto.getEmail());
		entity.setMatKhau(dto.getMatKhau());
		entity.setSoDienThoai(dto.getSoDienThoai());
		entity.setTaiKhoan(dto.getTaiKhoan());
		
		entity.setTinhTrang(dto.getTinhTrang());
		return entity;
	}
	
	public KhachHangDTO toDTO(KhachHangEntity entity) {
		KhachHangDTO dto = new KhachHangDTO();
		
		dto.setId(entity.getId());
		
		dto.setCMND(entity.getCMND());
		dto.setHoTen(entity.getHoTen());
		dto.setEmail(entity.getEmail());
		dto.setMatKhau(entity.getMatKhau());
		dto.setSoDienThoai(entity.getSoDienThoai());
		dto.setTaiKhoan(entity.getTaiKhoan());
		
		dto.setTinhTrang(entity.getTinhTrang());
		return dto;
	}

}
