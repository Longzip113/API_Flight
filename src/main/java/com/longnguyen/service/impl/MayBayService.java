package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.MayBayConverter;
import com.longnguyen.dto.MayBayDTO;
import com.longnguyen.entity.MayBayEntity;
import com.longnguyen.repository.MayBayRepository;
import com.longnguyen.service.IBasic;

@Service
public class MayBayService implements IBasic<MayBayDTO>{
	
	@Autowired
	MayBayRepository mayBayRepository;
	
	@Autowired
	MayBayConverter mayBayConverter;

	@Override
	public List<MayBayDTO> findAll() {
		List<MayBayDTO> mayBayDTOs = new ArrayList<MayBayDTO>();
		for (MayBayEntity item : mayBayRepository.findAll()) {
			MayBayDTO dto = mayBayConverter.toDTO(item);
			mayBayDTOs.add(dto);
		}
		return mayBayDTOs;
	}

	@Override
	public MayBayDTO save(MayBayDTO model) {
		MayBayEntity entity = mayBayConverter.toEntity(model);
		return mayBayConverter.toDTO(mayBayRepository.save(entity));
	}

	@Override
	public MayBayDTO update(MayBayDTO model) {
		MayBayEntity entity = mayBayConverter.toEntity(model);
		return mayBayConverter.toDTO(mayBayRepository.save(entity));
	}

	@Override
	public Boolean delete(Long[] ids) {
		for (Long id : ids) {
			mayBayRepository.delete(id);
		}
		return true;
	}

	@Override
	public MayBayDTO findOne(Long id) {
		return mayBayConverter.toDTO(mayBayRepository.getOne(id));
	}

}
