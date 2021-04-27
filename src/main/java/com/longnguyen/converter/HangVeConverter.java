package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.HangVeDTO;
import com.longnguyen.entity.HangVeEntity;

@Component
public class HangVeConverter {

	public HangVeEntity toEntity(HangVeDTO dto) {
		HangVeEntity entity = new HangVeEntity();
			
			entity.setId(dto.getId());
			
			entity.setCode(dto.getCode());
			entity.setTenHangVe(dto.getTenHangVe());
			
			entity.setTinhTrang(dto.getTinhTrang());
			return entity;
		}
		
		public HangVeDTO toDTO(HangVeEntity entity) {
			HangVeDTO dto = new HangVeDTO();
			
			dto.setId(entity.getId());
			
			dto.setCode(entity.getCode());
			dto.setTenHangVe(entity.getTenHangVe());
	
			dto.setTinhTrang(entity.getTinhTrang());
			return dto;
		}

	
}
