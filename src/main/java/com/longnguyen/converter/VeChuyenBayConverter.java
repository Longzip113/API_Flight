package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.VeChuyenBayDTO;
import com.longnguyen.entity.ChuyenBayEntity;
import com.longnguyen.entity.HangVeEntity;
import com.longnguyen.entity.VeChuyenBayEntity;

@Component
public class VeChuyenBayConverter {
	
	public VeChuyenBayEntity toEntity(VeChuyenBayDTO dto, ChuyenBayEntity chuyenBayEntity, HangVeEntity hangVeEntity) {
		VeChuyenBayEntity entity = new VeChuyenBayEntity();
		entity.setId(dto.getId());
		
		if(chuyenBayEntity != null)
		{
			entity.setChuyenBayEntity(chuyenBayEntity);
		}
		entity.setDonGia(dto.getDonGia());
		if(hangVeEntity != null)
		{
			entity.setHangVeEntity(hangVeEntity);
		}
		entity.setTinhTrang(dto.getTinhTrang());
		return entity;
	}
	
	public VeChuyenBayDTO toDTO(VeChuyenBayEntity entity) {
		VeChuyenBayDTO dto = new VeChuyenBayDTO();
		dto.setId(entity.getId());
		
		dto.setChuyenBayID(entity.getChuyenBayEntity().getId());
		dto.setDonGia(entity.getDonGia());
		dto.setHangVeID(entity.getHangVeEntity().getId());
		dto.setCodeHangVe(entity.getHangVeEntity().getCode());

		dto.setTinhTrang(entity.getTinhTrang());
		return dto;
	}
	
}
