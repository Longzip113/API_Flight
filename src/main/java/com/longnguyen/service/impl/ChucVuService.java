package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.ChucVuConverter;
import com.longnguyen.dto.ChucVuDTO;
import com.longnguyen.entity.ChucVuEntity;
import com.longnguyen.repository.ChucVuRepository;
import com.longnguyen.service.IBasic;

@Service
public class ChucVuService implements IBasic<ChucVuDTO> {
	
	@Autowired
	ChucVuConverter chucvuConverter;
	
	@Autowired
	ChucVuRepository chucVuRepository;
	

	@Override
	public List<ChucVuDTO> findAll() {
		List<ChucVuEntity> chucVuEntities = chucVuRepository.findAll();
		List<ChucVuDTO> chucVuDTOs = new ArrayList<ChucVuDTO>();
		
		for (ChucVuEntity item : chucVuEntities) {
			ChucVuDTO chucVuDTO = chucvuConverter.toDTO(item);
			chucVuDTOs.add(chucVuDTO);
		}
		
		return chucVuDTOs;
	}

	@Override
	public ChucVuDTO save(ChucVuDTO model) {
		ChucVuEntity entity = chucvuConverter.toEntity(model);
		return chucvuConverter.toDTO(chucVuRepository.save(entity));
	}

	@Override
	public ChucVuDTO update(ChucVuDTO model) {
		ChucVuEntity entity = chucvuConverter.toEntity(model);
		return chucvuConverter.toDTO(chucVuRepository.save(entity));
	}

	@Override
	public Boolean delete(Long id) {
		chucVuRepository.delete(id);
		return true;
	}

	@Override
	public ChucVuDTO findOne(Long id) {
		return chucvuConverter.toDTO(chucVuRepository.getOne(id));
	}

}
