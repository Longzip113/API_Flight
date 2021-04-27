package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.TuyenBayDTO;
import com.longnguyen.entity.SanBayEntity;
import com.longnguyen.entity.TuyenBayEntity;

@Component
public class TuyenBayConverter {

	public TuyenBayEntity toEntity(SanBayEntity sanDi, SanBayEntity sanDen, Long idTuyenBay) {
		TuyenBayEntity entity = new TuyenBayEntity();
		
		entity.setId(idTuyenBay);
		entity.setSanBayDen(sanDen);
		entity.setSanBaydi(sanDi);
		entity.setTinhTrang(true);
		
		return entity;
	}
	
	public TuyenBayDTO toDTO(TuyenBayEntity entity) {
		TuyenBayDTO dto = new TuyenBayDTO();
		
		dto.setId(entity.getId());
		dto.setSanBayDenID(entity.getSanBayDen().getId());
		dto.setSanBayDiID(entity.getSanBaydi().getId());
		dto.setTinhTrang(true);
		
		return dto;
	}
}
