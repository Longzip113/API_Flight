package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.PhieuDatVeConverter;
import com.longnguyen.dto.PhieuDatVeDTO;
import com.longnguyen.entity.ChuyenBayEntity;
import com.longnguyen.entity.KhachHangEntity;
import com.longnguyen.entity.PhieuDatVeEntity;
import com.longnguyen.entity.VeChuyenBayEntity;
import com.longnguyen.repository.ChuyenBayRepository;
import com.longnguyen.repository.KhachHangRepository;
import com.longnguyen.repository.MayBayRepository;
import com.longnguyen.repository.NhanVienRepository;
import com.longnguyen.repository.PhieuDatVeRepository;
import com.longnguyen.repository.VeChuyenBayRepository;
import com.longnguyen.service.IBasic;

@Service
public class PhieuDatVeService implements IBasic<PhieuDatVeDTO>{

	@Autowired
	VeChuyenBayRepository veChuyenBayRepository;
	
	@Autowired
	ChuyenBayRepository chuyenBayRepository;
	
	@Autowired
	MayBayRepository mayBayRepository;
	
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
		
		// Check khách hàng cũ hay mới
		KhachHangEntity checkKH = khachHangRepository.findByCmnd(model.getCMND());
		if(checkKH == null) {
			checkKH = new KhachHangEntity();
			checkKH.setCMND(model.getCMND());
			checkKH.setHoTen(model.getHoTen());
			checkKH.setSoDienThoai(model.getSoDienThoai());
			checkKH.setTinhTrang(true);
			KhachHangEntity entityKH = khachHangRepository.save(checkKH);
			model.setKhachHangID(entityKH.getId());
		} else {
			model.setKhachHangID(checkKH.getId());
		}
		KhachHangEntity khachHangEntity = khachHangRepository.getOne(model.getKhachHangID());
		VeChuyenBayEntity veChuyenBayEntity = veChuyenBayRepository.getOne(model.getVechuyenbayID());
		
		// Update số ghế 
		ChuyenBayEntity chuyenBayEntity = chuyenBayRepository.getOne(veChuyenBayEntity.getChuyenBayEntity().getId());
		if (veChuyenBayEntity.getHangVeEntity().getCode().equals("PT")) {
			chuyenBayEntity.setGhePhoThong(chuyenBayEntity.getGhePhoThong() - 1);
		} else {
			chuyenBayEntity.setGheThuongGia(chuyenBayEntity.getGheThuongGia() - 1);
		}
		chuyenBayRepository.save(chuyenBayEntity);
		
		// luu phieu dat ve
		PhieuDatVeEntity entity = phieuDatVeConverter.toEntity(model, khachHangEntity, veChuyenBayEntity);
		entity.setTinhTrang(true);
		entity.setNgayDat(new Date(System.currentTimeMillis()));
		entity.setMaVe("MVMB" + new Date(System.currentTimeMillis()).getTime());
		return phieuDatVeConverter.toDTO(phieuDatVeRepository.save(entity));
	}

	@Override
	public PhieuDatVeDTO update(PhieuDatVeDTO model) {
		KhachHangEntity khachHangEntity = khachHangRepository.getOne(model.getKhachHangID());
		VeChuyenBayEntity veChuyenBayEntity = veChuyenBayRepository.getOne(model.getVechuyenbayID());
		
		PhieuDatVeEntity entity = phieuDatVeConverter.toEntity(model, khachHangEntity, veChuyenBayEntity);
		return phieuDatVeConverter.toDTO(phieuDatVeRepository.save(entity));
	}

	@Override
	public Boolean delete(Long id) {
		phieuDatVeRepository.delete(id);
		return true;
	}

	@Override
	public PhieuDatVeDTO findOne(Long id) {
		return phieuDatVeConverter.toDTO(phieuDatVeRepository.getOne(id));
	}
	
}
