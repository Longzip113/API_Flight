package com.longnguyen.converter;

import org.springframework.stereotype.Component;

import com.longnguyen.dto.PhieuDatVeDTO;
import com.longnguyen.entity.KhachHangEntity;
import com.longnguyen.entity.NhanVienEntity;
import com.longnguyen.entity.PhieuDatVeEntity;
import com.longnguyen.entity.VeChuyenBayEntity;

@Component
public class PhieuDatVeConverter {

	public PhieuDatVeEntity toEntity(PhieuDatVeDTO dto, KhachHangEntity khachHangEntity, NhanVienEntity nhanVienEntity, VeChuyenBayEntity veChuyenBayEntity) {
		PhieuDatVeEntity entity = new PhieuDatVeEntity();
			
			entity.setId(dto.getId());
			
			entity.setGhiChu(dto.getGhiChu());
			entity.setMaGhe(dto.getMaGhe());
			entity.setNgayDat(dto.getNgayDat());
			entity.setThanhTien(dto.getThanhTien());
			entity.setCodePhieuDatVe(dto.getCodePhieuDatVe());
			entity.setKhachHangEntity(khachHangEntity);
			entity.setNhanVienEntity(nhanVienEntity);
			entity.setVeChuyenBayEntity(veChuyenBayEntity);
			
			entity.setTinhTrang(dto.getTinhTrang());
			return entity;
		}
		
		public PhieuDatVeDTO toDTO(PhieuDatVeEntity entity) {
			PhieuDatVeDTO dto = new PhieuDatVeDTO();
			
			dto.setId(entity.getId());
			
			dto.setGhiChu(entity.getGhiChu());
			dto.setMaGhe(entity.getMaGhe());
			dto.setNgayDat(entity.getNgayDat());
			dto.setThanhTien(entity.getThanhTien());
			dto.setCodePhieuDatVe(entity.getCodePhieuDatVe());
			dto.setKhachHangID(entity.getKhachHangEntity().getId());
			dto.setNhanVienID(entity.getNhanVienEntity().getId());
			dto.setVechuyenbayID(entity.getVeChuyenBayEntity().getId());
			
			dto.setTinhTrang(entity.getTinhTrang());
			return dto;
		}

	
}
