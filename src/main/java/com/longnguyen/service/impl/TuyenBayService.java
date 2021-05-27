package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.TuyenBayConverter;
import com.longnguyen.dto.TuyenBayDTO;
import com.longnguyen.entity.SanBayEntity;
import com.longnguyen.entity.TuyenBayEntity;
import com.longnguyen.repository.SanBayRepository;
import com.longnguyen.repository.TuyenBayRepository;
import com.longnguyen.service.IBasic;

@Service
public class TuyenBayService implements IBasic<TuyenBayDTO>{
	
	@Autowired
	TuyenBayRepository tuyenBayRepository;
	
	@Autowired
	SanBayRepository sanBayRepository;
	
	@Autowired
	TuyenBayConverter tuyenBayConverter;

	@Override
	public TuyenBayDTO save(TuyenBayDTO dto) {
		SanBayEntity sandi = sanBayRepository.findOne(dto.getSanBayDiID());
		SanBayEntity sanden = sanBayRepository.findOne(dto.getSanBayDenID());
		TuyenBayEntity entity = tuyenBayConverter.toEntity(sandi, sanden, null);
		return tuyenBayConverter.toDTO(tuyenBayRepository.save(entity));
	}

	@Override
	public TuyenBayDTO update(TuyenBayDTO dto) {
		SanBayEntity sandi = sanBayRepository.findOne(dto.getSanBayDiID());
		SanBayEntity sanden = sanBayRepository.findOne(dto.getSanBayDenID());
		TuyenBayEntity entity = tuyenBayConverter.toEntity(sandi, sanden, dto.getId());
		return tuyenBayConverter.toDTO(tuyenBayRepository.save(entity));
	}

	@Override
	public List<TuyenBayDTO> findAll() {
		List<TuyenBayDTO> tuyenBayDTOs = new ArrayList<TuyenBayDTO>();
		List<SanBayEntity> sanBayEntities = sanBayRepository.findAll();
		
		for (TuyenBayEntity item : tuyenBayRepository.findAll()) {
			TuyenBayDTO dto = tuyenBayConverter.toDTO(item);
			
			for (SanBayEntity sanBayEntity : sanBayEntities) {
				if(sanBayEntity.getId() == dto.getSanBayDiID())
				{
					dto.setTenSanBayDi(sanBayEntity.getTenSanBay());
					dto.setThanhPhoDi(sanBayEntity.getTenThanhPho());
				}
				
				if(sanBayEntity.getId() == dto.getSanBayDenID())
				{
					dto.setTenSanBayDen(sanBayEntity.getTenSanBay());
					dto.setThanhPhoDen(sanBayEntity.getTenThanhPho());
				}
			}
			
			tuyenBayDTOs.add(dto);
		}
		return tuyenBayDTOs;
	}

	@Override
	public Boolean delete(Long id) {
			tuyenBayRepository.delete(id);
		
		return true;
	}

	@Override
	public TuyenBayDTO findOne(Long id) {
		TuyenBayEntity entity = tuyenBayRepository.getOne(id);
		return tuyenBayConverter.toDTO(entity);
	}
	

}
