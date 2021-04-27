package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.ChuyenBayConverter;
import com.longnguyen.dto.ChuyenBayDTO;
import com.longnguyen.entity.ChuyenBayEntity;
import com.longnguyen.entity.MayBayEntity;
import com.longnguyen.entity.TuyenBayEntity;
import com.longnguyen.repository.ChuyenBayRepository;
import com.longnguyen.repository.MayBayRepository;
import com.longnguyen.repository.TuyenBayRepository;
import com.longnguyen.service.IBasic;

@Service
public class ChuyenBayService implements IBasic<ChuyenBayDTO>{
	
	@Autowired
	ChuyenBayRepository chuyenBayRepository;
	
	@Autowired
	TuyenBayRepository tuyenBayRepository;
	
	@Autowired
	MayBayRepository mayBayRepository;
	
	@Autowired
	ChuyenBayConverter chuyenBayConverter;
	
	
	@Override
	public List<ChuyenBayDTO> findAll() {
		List<ChuyenBayEntity> chucVuEntities = chuyenBayRepository.findAll();
		List<ChuyenBayDTO> dtos = new ArrayList<ChuyenBayDTO>();
		
		for (ChuyenBayEntity item : chucVuEntities) {
			ChuyenBayDTO dto = chuyenBayConverter.toDTO(item);
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public ChuyenBayDTO save(ChuyenBayDTO model) {
		TuyenBayEntity tuyenBayEntity = tuyenBayRepository.getOne(model.getTuyenBayId());
		MayBayEntity mayBayEntity = mayBayRepository.getOne(model.getMayBayId());
		ChuyenBayEntity entity = chuyenBayConverter.toEntity(model, mayBayEntity, tuyenBayEntity);
		return chuyenBayConverter.toDTO(chuyenBayRepository.save(entity));
	}

	@Override
	public ChuyenBayDTO update(ChuyenBayDTO model) {
		TuyenBayEntity tuyenBayEntity = tuyenBayRepository.getOne(model.getTuyenBayId());
		MayBayEntity mayBayEntity = mayBayRepository.getOne(model.getMayBayId());
		ChuyenBayEntity entity = chuyenBayConverter.toEntity(model, mayBayEntity, tuyenBayEntity);
		return chuyenBayConverter.toDTO(chuyenBayRepository.save(entity));
	}

	@Override
	public Boolean delete(Long[] ids) {
		for (Long id : ids) {
			chuyenBayRepository.delete(id);
		}
		return true;
	}

	@Override
	public ChuyenBayDTO findOne(Long id) {
		return chuyenBayConverter.toDTO(chuyenBayRepository.getOne(id));
	}
}
