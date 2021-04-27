package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longnguyen.converter.SanBayConverter;
import com.longnguyen.dto.SanBayDTO;
import com.longnguyen.entity.SanBayEntity;
import com.longnguyen.repository.SanBayRepository;
import com.longnguyen.service.ISanBayService;

@Service
public class SanBayService implements ISanBayService {

	@Autowired
	SanBayRepository sanBayRepository;

	@Autowired
	SanBayConverter sanBayConverter;

	@Override
	public List<SanBayDTO> findAll() {

		List<SanBayEntity> entities = sanBayRepository.findAll();
		List<SanBayDTO> dtos = new ArrayList<SanBayDTO>();
		for (SanBayEntity sanBayEntity : entities) {
			SanBayDTO dto = new SanBayDTO();
			dto = sanBayConverter.toDTO(sanBayEntity);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	@Transactional
	public SanBayDTO save(SanBayDTO model) {
		SanBayEntity entity = sanBayConverter.toEntity(model);
		return sanBayConverter.toDTO(sanBayRepository.save(entity));
	}

	@Override
	public SanBayDTO update(SanBayDTO model) {
		SanBayEntity entity = sanBayConverter.toEntity(model);
		return sanBayConverter.toDTO(sanBayRepository.save(entity));
	}

	@Override
	public Boolean delete(Long[] ids) {
		for (Long id : ids) {
			sanBayRepository.delete(id);
		}
		return true;
	}

	@Override
	public SanBayDTO findOne(Long id) {
		return sanBayConverter.toDTO(sanBayRepository.getOne(id));
	}

	@Override
	public SanBayDTO findByCode(String code) {
		return sanBayConverter.toDTO(sanBayRepository.findByCode(code));
	}

}
