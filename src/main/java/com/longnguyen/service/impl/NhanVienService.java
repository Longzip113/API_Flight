package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.NhanVienCoverter;
import com.longnguyen.dto.NhanVienDTO;
import com.longnguyen.entity.ChucVuEntity;
import com.longnguyen.entity.NhanVienEntity;
import com.longnguyen.repository.ChucVuRepository;
import com.longnguyen.repository.NhanVienRepository;
import com.longnguyen.service.IBasic;

@Service
public class NhanVienService implements IBasic<NhanVienDTO>{

	@Autowired
	NhanVienRepository nhanVienRepository;
	
	@Autowired
	ChucVuRepository chucVuRepository;

	@Autowired
	NhanVienCoverter nhanVienCoverter;
	
	@Override
	public List<NhanVienDTO> findAll() {
		List<NhanVienDTO> nhanVienDTOs = new ArrayList<NhanVienDTO>();
		for (NhanVienEntity item : nhanVienRepository.findAll()) {
			NhanVienDTO dto = nhanVienCoverter.toDTO(item, item.getChucVuEntity().getId());
			nhanVienDTOs.add(dto);
		}
		return nhanVienDTOs;
	}

	@Override
	public NhanVienDTO save(NhanVienDTO model) {
		ChucVuEntity chucVuEntity = chucVuRepository.getOne(model.getChucVuID());
		NhanVienEntity entity = nhanVienCoverter.toEntity(model, chucVuEntity);
		return nhanVienCoverter.toDTO(nhanVienRepository.save(entity), model.getChucVuID());
	}

	@Override
	public NhanVienDTO update(NhanVienDTO model) {
		ChucVuEntity chucVuEntity = chucVuRepository.getOne(model.getChucVuID());
		NhanVienEntity entity = nhanVienCoverter.toEntity(model, chucVuEntity);
		return nhanVienCoverter.toDTO(nhanVienRepository.save(entity), model.getChucVuID());
	}

	@Override
	public Boolean delete(Long id) {
		nhanVienRepository.delete(id);
		return true;
	}

	@Override
	public NhanVienDTO findOne(Long id) {
		NhanVienEntity entity = nhanVienRepository.getOne(id);
		return nhanVienCoverter.toDTO(entity, entity.getChucVuEntity().getId());
	}

}
