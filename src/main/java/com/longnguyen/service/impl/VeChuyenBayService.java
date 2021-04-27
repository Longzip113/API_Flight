package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.VeChuyenBayConverter;
import com.longnguyen.dto.VeChuyenBayDTO;
import com.longnguyen.entity.ChuyenBayEntity;
import com.longnguyen.entity.HangVeEntity;
import com.longnguyen.entity.VeChuyenBayEntity;
import com.longnguyen.repository.ChuyenBayRepository;
import com.longnguyen.repository.HangVeRepository;
import com.longnguyen.repository.VeChuyenBayRepository;
import com.longnguyen.service.IBasic;

@Service
public class VeChuyenBayService implements IBasic<VeChuyenBayDTO>{
	
	@Autowired
	VeChuyenBayRepository veChuyenBayRepository;
	
	@Autowired
	ChuyenBayRepository chuyenBayRepository;
	
	@Autowired
	HangVeRepository hangVeRepository;
	
	@Autowired
	VeChuyenBayConverter veChuyenBayConverter;
	
	@Override
	public List<VeChuyenBayDTO> findAll() {
		List<VeChuyenBayEntity> chucVuEntities = veChuyenBayRepository.findAll();
		List<VeChuyenBayDTO> dtos = new ArrayList<VeChuyenBayDTO>();
		
		for (VeChuyenBayEntity item : chucVuEntities) {
			VeChuyenBayDTO dto = veChuyenBayConverter.toDTO(item);
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public VeChuyenBayDTO save(VeChuyenBayDTO model) {
		HangVeEntity hangVeEntity = hangVeRepository.getOne(model.getHangVeID());
		ChuyenBayEntity chuyenBayEntity = chuyenBayRepository.getOne(model.getChuyenBayID());
		VeChuyenBayEntity entity = veChuyenBayConverter.toEntity(model, chuyenBayEntity, hangVeEntity);
		return veChuyenBayConverter.toDTO(veChuyenBayRepository.save(entity));
	}

	@Override
	public VeChuyenBayDTO update(VeChuyenBayDTO model) {
		HangVeEntity hangVeEntity = hangVeRepository.getOne(model.getHangVeID());
		ChuyenBayEntity chuyenBayEntity = chuyenBayRepository.getOne(model.getChuyenBayID());
		VeChuyenBayEntity entity = veChuyenBayConverter.toEntity(model, chuyenBayEntity, hangVeEntity);
		return veChuyenBayConverter.toDTO(veChuyenBayRepository.save(entity));
	}

	@Override
	public Boolean delete(Long[] ids) {
		for (Long id : ids) {
			veChuyenBayRepository.delete(id);
		}
		return true;
	}

	@Override
	public VeChuyenBayDTO findOne(Long id) {
		return veChuyenBayConverter.toDTO(veChuyenBayRepository.getOne(id));
	}
	
	

}
