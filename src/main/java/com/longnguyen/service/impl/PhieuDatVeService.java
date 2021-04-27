package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.PhieuDatVeConverter;
import com.longnguyen.dto.PhieuDatVeDTO;
import com.longnguyen.entity.KhachHangEntity;
import com.longnguyen.entity.NhanVienEntity;
import com.longnguyen.entity.PhieuDatVeEntity;
import com.longnguyen.entity.VeChuyenBayEntity;
import com.longnguyen.repository.KhachHangRepository;
import com.longnguyen.repository.NhanVienRepository;
import com.longnguyen.repository.PhieuDatVeRepository;
import com.longnguyen.repository.VeChuyenBayRepository;
import com.longnguyen.service.IBasic;

@Service
public class PhieuDatVeService implements IBasic<PhieuDatVeDTO>{

	@Autowired
	VeChuyenBayRepository veChuyenBayRepository;
	
	@Autowired
	PhieuDatVeRepository phieuDatVeRepository;
	
	@Autowired
	KhachHangRepository khachHangRepository;
	
	@Autowired
	NhanVienRepository nhanVienRepository;
	
	@Autowired
	PhieuDatVeConverter phieuDatVeConverter;
	
	@Override
	public List<PhieuDatVeDTO> findAll() {
		List<PhieuDatVeEntity> chucVuEntities = phieuDatVeRepository.findAll();
		List<PhieuDatVeDTO> dtos = new ArrayList<PhieuDatVeDTO>();
		
		for (PhieuDatVeEntity item : chucVuEntities) {
			PhieuDatVeDTO dto = phieuDatVeConverter.toDTO(item);
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public PhieuDatVeDTO save(PhieuDatVeDTO model) {
		NhanVienEntity nhanVienEntity = nhanVienRepository.getOne(model.getNhanVienID());
		KhachHangEntity khachHangEntity = khachHangRepository.getOne(model.getKhachHangID());
		VeChuyenBayEntity veChuyenBayEntity = veChuyenBayRepository.getOne(model.getVechuyenbayID());
		
		PhieuDatVeEntity entity = phieuDatVeConverter.toEntity(model, khachHangEntity, nhanVienEntity, veChuyenBayEntity);
		return phieuDatVeConverter.toDTO(phieuDatVeRepository.save(entity));
	}

	@Override
	public PhieuDatVeDTO update(PhieuDatVeDTO model) {
		NhanVienEntity nhanVienEntity = nhanVienRepository.getOne(model.getNhanVienID());
		KhachHangEntity khachHangEntity = khachHangRepository.getOne(model.getKhachHangID());
		VeChuyenBayEntity veChuyenBayEntity = veChuyenBayRepository.getOne(model.getVechuyenbayID());
		
		PhieuDatVeEntity entity = phieuDatVeConverter.toEntity(model, khachHangEntity, nhanVienEntity, veChuyenBayEntity);
		return phieuDatVeConverter.toDTO(phieuDatVeRepository.save(entity));
	}

	@Override
	public Boolean delete(Long[] ids) {
		for (Long id : ids) {
			phieuDatVeRepository.delete(id);
		}
		return true;
	}

	@Override
	public PhieuDatVeDTO findOne(Long id) {
		return phieuDatVeConverter.toDTO(phieuDatVeRepository.getOne(id));
	}
	
}
