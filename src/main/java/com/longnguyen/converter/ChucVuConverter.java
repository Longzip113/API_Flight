package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.ChucVuDTO;
import com.longnguyen.entity.ChucVuEntity;

@Component
public class ChucVuConverter {
	
	public ChucVuEntity toEntity(ChucVuDTO dto) {
		ChucVuEntity entity = new ChucVuEntity();
		
		entity.setId(dto.getId());
		
		entity.setCode(dto.getCode());
		entity.setTenChucVu(dto.getTenChucVu());
		
		entity.setTinhTrang(dto.getTinhTrang());
		return entity;
	}
	
	public ChucVuDTO toDTO(ChucVuEntity entity) {
		ChucVuDTO dto = new ChucVuDTO();
		
		dto.setId(entity.getId());
		
		dto.setCode(entity.getCode());
		dto.setTenChucVu(entity.getTenChucVu());

		dto.setTinhTrang(entity.getTinhTrang());
		return dto;
	}
}
