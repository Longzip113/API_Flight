package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.PhieuDatVeDTO;
import com.longnguyen.entity.KhachHangEntity;
import com.longnguyen.entity.PhieuDatVeEntity;
import com.longnguyen.entity.VeChuyenBayEntity;

@Component
public class PhieuDatVeConverter {

	public PhieuDatVeEntity toEntity(PhieuDatVeDTO dto, KhachHangEntity khachHangEntity, VeChuyenBayEntity veChuyenBayEntity) {
		PhieuDatVeEntity entity = new PhieuDatVeEntity();
			
			entity.setId(dto.getId());
			
			entity.setGhiChu(dto.getGhiChu());
			entity.setMaVe(dto.getMaVe());
			entity.setNgayDat(dto.getNgayDat());
			entity.setThanhTien(dto.getThanhTien());
			entity.setRoleDatVe(dto.getRoleDatVe());
			entity.setNguoiDatVe_id(dto.getNguoiDatVe_id());
			entity.setKhachHangEntity(khachHangEntity);
			entity.setVeChuyenBayEntity(veChuyenBayEntity);
			
			entity.setTinhTrang(dto.getTinhTrang());
			return entity;
		}
		
		public PhieuDatVeDTO toDTO(PhieuDatVeEntity entity) {
			PhieuDatVeDTO dto = new PhieuDatVeDTO();
			
			dto.setId(entity.getId());
			dto.setNguoiDatVe_id(entity.getNguoiDatVe_id());
			dto.setGhiChu(entity.getGhiChu());
			dto.setMaVe(entity.getMaVe());
			dto.setNgayDat(entity.getNgayDat());
			dto.setThanhTien(entity.getThanhTien());
			dto.setRoleDatVe(entity.getRoleDatVe());
			dto.setKhachHangID(entity.getKhachHangEntity().getId());
			dto.setVechuyenbayID(entity.getVeChuyenBayEntity().getId());
			
			dto.setTinhTrang(entity.getTinhTrang());
			return dto;
		}

	
}
