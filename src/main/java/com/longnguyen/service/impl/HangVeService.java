package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.HangVeConverter;
import com.longnguyen.dto.HangVeDTO;
import com.longnguyen.entity.HangVeEntity;
import com.longnguyen.repository.HangVeRepository;
import com.longnguyen.service.IBasic;

@Service
public class HangVeService implements IBasic<HangVeDTO>{
	
	@Autowired
	HangVeConverter hangVeConverter;
	
	@Autowired
	HangVeRepository hangVeRepository;
	
	@Override
	public List<HangVeDTO> findAll() {
		List<HangVeEntity> hangVeEntities = hangVeRepository.findAll();
		List<HangVeDTO> hangVeDTOs = new ArrayList<HangVeDTO>();
		
		for (HangVeEntity item : hangVeEntities) {
			HangVeDTO chucVuDTO = hangVeConverter.toDTO(item);
			hangVeDTOs.add(chucVuDTO);
		}
		
		return hangVeDTOs;
	}

	@Override
	public HangVeDTO save(HangVeDTO model) {
		HangVeEntity entity = hangVeConverter.toEntity(model);
		return hangVeConverter.toDTO(hangVeRepository.save(entity));
	}

	@Override
	public HangVeDTO update(HangVeDTO model) {
		HangVeEntity entity = hangVeConverter.toEntity(model);
		return hangVeConverter.toDTO(hangVeRepository.save(entity));
	}

	@Override
	public Boolean delete(Long[] ids) {
		for (Long id : ids) {
			hangVeRepository.delete(id);
		}
		return true;
	}

	@Override
	public HangVeDTO findOne(Long id) {
		return hangVeConverter.toDTO(hangVeRepository.getOne(id));
	}
	
}
