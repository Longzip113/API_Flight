package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.KhachHangConverter;
import com.longnguyen.dto.KhachHangDTO;
import com.longnguyen.entity.KhachHangEntity;
import com.longnguyen.repository.KhachHangRepository;
import com.longnguyen.service.IKhachHangService;

@Service
public class KhachHangSerice implements IKhachHangService{
	
	@Autowired
	KhachHangConverter khachHangConverter;
	
	@Autowired
	KhachHangRepository khachHangRepository;

	@Override
	public List<KhachHangDTO> findAll() {
		List<KhachHangDTO> khachHangDTOs = new ArrayList<KhachHangDTO>();
		for (KhachHangEntity item : khachHangRepository.findAll()) {
			KhachHangDTO dto = khachHangConverter.toDTO(item);
			khachHangDTOs.add(dto);
		}
		return khachHangDTOs;
	}

	@Override
	public KhachHangDTO save(KhachHangDTO model) {
		KhachHangEntity entity = khachHangConverter.toEntity(model);
		return khachHangConverter.toDTO(khachHangRepository.save(entity));
	}

	@Override
	public KhachHangDTO update(KhachHangDTO model) {
		KhachHangEntity entity = khachHangConverter.toEntity(model);
		return khachHangConverter.toDTO(khachHangRepository.save(entity));
	}

	@Override
	public Boolean delete(Long id) {
		khachHangRepository.delete(id);
		return true;
	}

	@Override
	public KhachHangDTO login(KhachHangDTO khachHangDTO) {
		KhachHangEntity entity = khachHangRepository.findByUserNameAndPassWord(khachHangDTO.getMatKhau(), khachHangDTO.getTaiKhoan());
		if (entity != null) {
			return khachHangConverter.toDTO(entity);
		}
		return null;
	}

	@Override
	public KhachHangDTO findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
