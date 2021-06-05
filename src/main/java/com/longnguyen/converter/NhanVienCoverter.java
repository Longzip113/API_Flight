package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.NhanVienDTO;
import com.longnguyen.entity.ChucVuEntity;
import com.longnguyen.entity.NhanVienEntity;

@Component
public class NhanVienCoverter {
	
	public NhanVienEntity toEntity(NhanVienDTO dto, ChucVuEntity chucVuEntity) {
		NhanVienEntity entity = new NhanVienEntity();
		
		entity.setId(dto.getId());
		
		entity.setChucVuEntity(chucVuEntity);
		entity.setCMND(dto.getCMND());
		entity.setHoTen(dto.getHoTen());
		entity.setMatKhau(dto.getMatKhau());
		entity.setSoDienThoai(dto.getSoDienThoai());
		entity.setTaiKhoan(dto.getTaiKhoan());
		entity.setTinhTrang(dto.getTinhTrang());
		return entity;
	}
	
	public NhanVienDTO toDTO(NhanVienEntity entity, Long idChucVu) {
		NhanVienDTO dto = new NhanVienDTO();
		
		dto.setId(entity.getId());
		
		dto.setChucVuID(idChucVu);
		dto.setCMND(entity.getCMND());
		dto.setHoTen(entity.getHoTen());
		dto.setMatKhau(entity.getMatKhau());
		dto.setSoDienThoai(entity.getSoDienThoai());
		dto.setTaiKhoan(entity.getTaiKhoan());
		
		dto.setTinhTrang(entity.getTinhTrang());
		return dto;
	}

}
