package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.MayBayDTO;
import com.longnguyen.entity.MayBayEntity;

@Component
public class MayBayConverter {
	
	public MayBayEntity toEntity(MayBayDTO dto) {
		MayBayEntity entity = new MayBayEntity();
		
		entity.setId(dto.getId());
		
		entity.setTenMayBay(dto.getTenMayBay());
		entity.setHangMayBay(dto.getHangMayBay());
		entity.setSoGheHang1(dto.getSoGheHang1());
		entity.setSoGheHang2(dto.getSoGheHang2());
		
		entity.setTinhTrang(dto.getTinhTrang());
		return entity;
	}
	
	public MayBayDTO toDTO(MayBayEntity entity) {
		MayBayDTO dto = new MayBayDTO();
		
		dto.setId(entity.getId());
		
		dto.setTenMayBay(entity.getTenMayBay());
		dto.setHangMayBay(entity.getHangMayBay());
		dto.setSoGheHang1(entity.getSoGheHang1());
		dto.setSoGheHang2(entity.getSoGheHang2());

		dto.setTinhTrang(entity.getTinhTrang());
		return dto;
	}

}
