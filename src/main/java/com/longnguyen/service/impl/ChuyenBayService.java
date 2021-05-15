package com.longnguyen.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.ChuyenBayConverter;
import com.longnguyen.dto.ChuyenBayDTO;
import com.longnguyen.dto.SanBayDTO;
import com.longnguyen.entity.ChuyenBayEntity;
import com.longnguyen.entity.MayBayEntity;
import com.longnguyen.entity.TuyenBayEntity;
import com.longnguyen.entity.VeChuyenBayEntity;
import com.longnguyen.repository.ChuyenBayRepository;
import com.longnguyen.repository.MayBayRepository;
import com.longnguyen.repository.SanBayRepository;
import com.longnguyen.repository.TuyenBayRepository;
import com.longnguyen.repository.VeChuyenBayRepository;
import com.longnguyen.service.IChuyenBayService;
import com.longnguyen.service.ISanBayService;

@Service
public class ChuyenBayService implements IChuyenBayService{
	
	@Autowired
	ChuyenBayRepository chuyenBayRepository;
	
	@Autowired
	TuyenBayRepository tuyenBayRepository;
	
	@Autowired
	MayBayRepository mayBayRepository;
	
	@Autowired
	SanBayRepository sanBayRepository;
	
	@Autowired
	VeChuyenBayRepository veChuyenBayRepository;
	
	@Autowired
	ISanBayService sanBayService;
	
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
		ChuyenBayDTO model = new ChuyenBayDTO();
		if(id != null) {
			model = chuyenBayConverter.toDTO(chuyenBayRepository.getOne(id));
			TuyenBayEntity tuyenBayEntity = tuyenBayRepository.getOne(model.getTuyenBayId());
			SanBayDTO sanBayDTODi = sanBayService.findOne(tuyenBayEntity.getSanBaydi().getId());
			SanBayDTO sanBayDTODen = sanBayService.findOne(tuyenBayEntity.getSanBayDen().getId());
			
			MayBayEntity mayBayEntity = mayBayRepository.getOne(model.getMayBayId());
			model.setHangVe(mayBayEntity.getHangMayBay());
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = model.getNgayGio();
			model.setNgay(dateFormat.format(date).toString());
			
			DateFormat dateFormat1 = new SimpleDateFormat("HH.mm");
			Date date1 = model.getNgayGio();
			model.setGio(dateFormat1.format(date1).toString());
			
			model.setCodeSanDi("" + sanBayDTODi.getCode());
			model.setCodeSanDen("" + sanBayDTODen.getCode());
		}
		return model;
	}

	@Override
	public List<ChuyenBayDTO> findAllByNgayGio(String ngayGio,Long id) {
		List<ChuyenBayEntity> chucVuEntities = new ArrayList<ChuyenBayEntity>();
		try {
			chucVuEntities = chuyenBayRepository.findAllByNgayGioAndTuyenBayEntity(new SimpleDateFormat("yyyy-MM-dd").parse(ngayGio), id);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<ChuyenBayDTO> dtos = new ArrayList<ChuyenBayDTO>();
		
		for (ChuyenBayEntity item : chucVuEntities) {
			ChuyenBayDTO dto = chuyenBayConverter.toDTO(item);
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public List<ChuyenBayDTO> findChuyenBay(ChuyenBayDTO model) {
		
		TuyenBayEntity tuyenBayEntity = tuyenBayRepository.findByIDDenAndIDDi(model.getSanBayDenID(), model.getSanBayDiID());
		SanBayDTO sanBayDTODi = sanBayService.findOne(model.getSanBayDiID());
		SanBayDTO sanBayDTODen = sanBayService.findOne(model.getSanBayDenID());
		
		List<ChuyenBayDTO> list = findAllByNgayGio(model.getNgayDi().toString(),tuyenBayEntity.getId());
		
		list.forEach(item -> {
			MayBayEntity mayBayEntity = mayBayRepository.getOne(item.getMayBayId());
			item.setHangVe(mayBayEntity.getHangMayBay());
			
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = item.getNgayGio();
			item.setNgay(dateFormat.format(date).toString());
			
			DateFormat dateFormat1 = new SimpleDateFormat("HH.mm");
			Date date1 = item.getNgayGio();
			item.setGio(dateFormat1.format(date1).toString());
			
			
			List<VeChuyenBayEntity> veChuyenBayEntities = veChuyenBayRepository.findByIDChuyenBay(item.getId());
			veChuyenBayEntities.forEach(ve -> {
				if(ve.getHangVeEntity().getId() == 1 && model.getLoaiVe().equals("PT")) {
					item.setIdVe(ve.getId());
					item.setDonGia(ve.getDonGia() + "");
				}
				if(ve.getHangVeEntity().getId() == 2 && model.getLoaiVe().equals("TG")) {
					item.setIdVe(ve.getId());
					item.setDonGia(ve.getDonGia() + "");
				}
			});
			
			item.setCodeSanDi("" + sanBayDTODi.getCode());
			item.setCodeSanDen("" + sanBayDTODen.getCode());
		});
		
		return list;
	}

	@Override
	public ChuyenBayDTO findOneChuyenBay(Long id, Long idVe) {
		ChuyenBayDTO model = new ChuyenBayDTO();
		if(id != null) {
			model = chuyenBayConverter.toDTO(chuyenBayRepository.getOne(id));
			TuyenBayEntity tuyenBayEntity = tuyenBayRepository.getOne(model.getTuyenBayId());
			SanBayDTO sanBayDTODi = sanBayService.findOne(tuyenBayEntity.getSanBaydi().getId());
			SanBayDTO sanBayDTODen = sanBayService.findOne(tuyenBayEntity.getSanBayDen().getId());
			
			MayBayEntity mayBayEntity = mayBayRepository.getOne(model.getMayBayId());
			model.setHangVe(mayBayEntity.getHangMayBay());
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = model.getNgayGio();
			model.setNgay(dateFormat.format(date).toString());
			
			DateFormat dateFormat1 = new SimpleDateFormat("HH.mm");
			Date date1 = model.getNgayGio();
			model.setGio(dateFormat1.format(date1).toString());
			
			VeChuyenBayEntity veChuyenBayEntity = veChuyenBayRepository.getOne(idVe);
			model.setIdVe(veChuyenBayEntity.getId());
			model.setDonGia(veChuyenBayEntity.getDonGia() + "");

			model.setCodeSanDi("" + sanBayDTODi.getCode());
			model.setCodeSanDen("" + sanBayDTODen.getCode());
		}
		return model;
	}
	
	
}
