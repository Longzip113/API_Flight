package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.ChuyenBayDTO;
import com.longnguyen.entity.ChuyenBayEntity;
import com.longnguyen.entity.MayBayEntity;
import com.longnguyen.entity.TuyenBayEntity;

@Component
public class ChuyenBayConverter {
	
	public ChuyenBayEntity toEntity(ChuyenBayDTO dto, MayBayEntity mayBayEntity, TuyenBayEntity tuyenBayEntity) {
		ChuyenBayEntity entity = new ChuyenBayEntity();
		entity.setId(dto.getId());
		
		entity.setNgayGio(dto.getNgayGio());
		entity.setThoiGianBay(dto.getThoiGianBay());
		entity.setMayBayEntity(mayBayEntity);
		entity.setTuyenBayEntity(tuyenBayEntity);
		entity.setGhePhoThong(dto.getGhePhoThong());
		entity.setGheThuongGia(dto.getGheThuongGia());
		entity.setTinhTrang(dto.getTinhTrang());
		entity.setGio(dto.getGio());
		return entity;
	}
	
	public ChuyenBayDTO toDTO(ChuyenBayEntity entity) {
		ChuyenBayDTO dto = new ChuyenBayDTO();
		dto.setId(entity.getId());
		
		dto.setNgayGio(entity.getNgayGio());
		dto.setThoiGianBay(entity.getThoiGianBay());
		dto.setMayBayId(entity.getMayBayEntity().getId());
		dto.setTuyenBayId(entity.getTuyenBayEntity().getId());
		dto.setGhePhoThong(entity.getGhePhoThong());
		dto.setGheThuongGia(entity.getGheThuongGia());
		dto.setTinhTrang(entity.getTinhTrang());
		dto.setGio(entity.getGio());
		return dto;
	}
}
