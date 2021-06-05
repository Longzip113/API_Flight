package com.longnguyen.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.converter.KhachHangConverter;
import com.longnguyen.converter.PhieuDatVeConverter;
import com.longnguyen.converter.VeChuyenBayConverter;
import com.longnguyen.dto.ChuyenBayDTO;
import com.longnguyen.dto.KhachHangDTO;
import com.longnguyen.dto.NhanVienDTO;
import com.longnguyen.dto.PhieuDatVeDTO;
import com.longnguyen.dto.SanBayDTO;
import com.longnguyen.dto.TuyenBayDTO;
import com.longnguyen.dto.VeChuyenBayDTO;
import com.longnguyen.entity.KhachHangEntity;
import com.longnguyen.entity.PhieuDatVeEntity;
import com.longnguyen.entity.VeChuyenBayEntity;
import com.longnguyen.repository.ChuyenBayRepository;
import com.longnguyen.repository.KhachHangRepository;
import com.longnguyen.repository.MayBayRepository;
import com.longnguyen.repository.NhanVienRepository;
import com.longnguyen.repository.PhieuDatVeRepository;
import com.longnguyen.repository.SanBayRepository;
import com.longnguyen.repository.TuyenBayRepository;
import com.longnguyen.repository.VeChuyenBayRepository;
import com.longnguyen.service.IBasic;

@Service
public class PhieuDatVeService implements IBasic<PhieuDatVeDTO>{

	@Autowired
	VeChuyenBayRepository veChuyenBayRepository;
	
	@Autowired
	VeChuyenBayService veChuyenBayService;
	
	@Autowired
	ChuyenBayRepository chuyenBayRepository;
	
	@Autowired
	ChuyenBayService chuyenBayService;
	
	@Autowired
	MayBayRepository mayBayRepository;
	
	@Autowired
	PhieuDatVeRepository phieuDatVeRepository;
	
	@Autowired
	KhachHangRepository khachHangRepository;
	
	@Autowired
	KhachHangSerice khachHangSerice;
	
	@Autowired
	NhanVienRepository nhanVienRepository;
	
	@Autowired
	NhanVienService nhanVienService;
	
	@Autowired
	TuyenBayRepository tuyenBayRepository;
	
	@Autowired
	TuyenBayService tuyenBayService;
	
	@Autowired
	SanBayRepository sanBayRepository;
	
	@Autowired
	SanBayService sanBayService;
	
	@Autowired
	PhieuDatVeConverter phieuDatVeConverter;
	
	@Autowired
	KhachHangConverter khachHangConverter;
	
	@Autowired
	VeChuyenBayConverter veChuyenBayConverter;
	
	@Override
	public List<PhieuDatVeDTO> findAll() {
		List<PhieuDatVeEntity> phieuDatVeEntities = phieuDatVeRepository.findAll();
		
		List<PhieuDatVeDTO> dtos = new ArrayList<PhieuDatVeDTO>();
		for (PhieuDatVeEntity item : phieuDatVeEntities) {
			PhieuDatVeDTO dto = phieuDatVeConverter.toDTO(item);
			KhachHangDTO khachHangDTO = khachHangSerice.findOne(dto.getKhachHangID());
			if(dto.getRoleDatVe() == 1) {
				NhanVienDTO nhanVienDTO = nhanVienService.findOne(dto.getNguoiDatVe_id());
				dto.setHoTenNhanVien(nhanVienDTO.getHoTen());
			}
			else {
				dto.setHoTenNhanVien("Khách hàng đặt !!");
			}
			VeChuyenBayDTO veChuyenBayDTO = veChuyenBayService.findOne(dto.getVechuyenbayID());
			ChuyenBayDTO chuyenBayDTO = chuyenBayService.findOne(veChuyenBayDTO.getChuyenBayID());
			TuyenBayDTO tuyenBayDTO = tuyenBayService.findOne(chuyenBayDTO.getTuyenBayId());
			SanBayDTO sanBayDi = sanBayService.findOne(tuyenBayDTO.getSanBayDiID());
			SanBayDTO sanBayDen = sanBayService.findOne(tuyenBayDTO.getSanBayDenID());
			
			dto.setTuyenBay(sanBayDi.getTenSanBay() + " -- " + sanBayDen.getTenSanBay());
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = chuyenBayDTO.getNgayGio();
			
			dto.setThoiGianBay(dateFormat.format(date).toString());
			
			dto.setCMND(khachHangDTO.getCMND());
			dto.setEmail(khachHangDTO.getEmail());
			dto.setHoTen(khachHangDTO.getHoTen());
			dto.setSoDienThoai(khachHangDTO.getSoDienThoai());
			
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public PhieuDatVeDTO save(PhieuDatVeDTO model) {
		
		// Check khách hàng cũ hay mới
		KhachHangDTO checkKH = khachHangSerice.findByCmnd(model.getCMND());
		if(checkKH == null) {
			checkKH = new KhachHangDTO();
			checkKH.setCMND(model.getCMND());
			checkKH.setHoTen(model.getHoTen());
			checkKH.setEmail(model.getEmail());
			checkKH.setSoDienThoai(model.getSoDienThoai());
			checkKH.setTinhTrang(true);
			KhachHangDTO dtoKH = khachHangSerice.save(checkKH);
			model.setKhachHangID(dtoKH.getId());
		} else {
			model.setKhachHangID(checkKH.getId());
		}
		VeChuyenBayDTO veChuyenBayDTO = veChuyenBayService.findOne(model.getVechuyenbayID());
		
		// Update số ghế 
		ChuyenBayDTO chuyenBayDTO = chuyenBayService.findOne(veChuyenBayDTO.getChuyenBayID());
		if (veChuyenBayDTO.getCodeHangVe().equals("PT")) {
			chuyenBayDTO.setGhePhoThong(chuyenBayDTO.getGhePhoThong() - 1);
		} else {
			chuyenBayDTO.setGheThuongGia(chuyenBayDTO.getGheThuongGia() - 1);
		}
		chuyenBayService.save(chuyenBayDTO);
		
//		// luu phieu dat ve
//		KhachHangEntity khachHangEntity = khachHangConverter.toEntity(khachHangDTO);
//		VeChuyenBayEntity veChuyenBayEntity = veChuyenBayConverter.toEntity(veChuyenBayDTO, null, null);
		
		KhachHangEntity khachHangEntity = khachHangRepository.getOne(model.getKhachHangID());
		VeChuyenBayEntity veChuyenBayEntity = veChuyenBayRepository.getOne(model.getVechuyenbayID());
		PhieuDatVeEntity entity = phieuDatVeConverter.toEntity(model, khachHangEntity, veChuyenBayEntity);
		entity.setTinhTrang(true);
		entity.setNgayDat(new Date(System.currentTimeMillis()));
		entity.setMaVe("MVMB" + new Date(System.currentTimeMillis()).getTime());
		return phieuDatVeConverter.toDTO(phieuDatVeRepository.save(entity));
	}

	@Override
	public PhieuDatVeDTO update(PhieuDatVeDTO model) {
		KhachHangEntity khachHangEntity = khachHangRepository.getOne(model.getKhachHangID());
		VeChuyenBayEntity veChuyenBayEntity = veChuyenBayRepository.getOne(model.getVechuyenbayID());
		
		PhieuDatVeEntity entity = phieuDatVeConverter.toEntity(model, khachHangEntity, veChuyenBayEntity);
		return phieuDatVeConverter.toDTO(phieuDatVeRepository.save(entity));
	}

	@Override
	public Boolean delete(Long id) {
		phieuDatVeRepository.delete(id);
		return true;
	}

	@Override
	public PhieuDatVeDTO findOne(Long id) {
		return phieuDatVeConverter.toDTO(phieuDatVeRepository.findOne(id));
	}
	
}
