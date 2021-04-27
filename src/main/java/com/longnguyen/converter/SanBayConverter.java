package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.SanBayDTO;
import com.longnguyen.entity.SanBayEntity;

@Component
public class SanBayConverter {

	public SanBayEntity toEntity(SanBayDTO dto) {
		SanBayEntity entity = new SanBayEntity();
		
		entity.setId(dto.getId());
		entity.setTenSanBay(dto.getTenSanBay());
		entity.setTenThanhPho(dto.getTenThanhPho());
		entity.setCode(dto.getCode());
		entity.setQuocGia(dto.getQuocGia());
		entity.setTinhTrang(dto.getTinhTrang());
		
		return entity;
	}
	
	public SanBayDTO toDTO(SanBayEntity entity) {
		SanBayDTO dto = new SanBayDTO();
		
		dto.setId(entity.getId());
		dto.setTenSanBay(entity.getTenSanBay());
		dto.setTenThanhPho(entity.getTenThanhPho());
		dto.setCode(entity.getCode());
		dto.setQuocGia(entity.getQuocGia());
		dto.setTinhTrang(entity.getTinhTrang());
		
		return dto;
	}
}
