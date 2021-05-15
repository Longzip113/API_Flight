package com.longnguyen.service;

import java.util.List;

import com.longnguyen.dto.ChuyenBayDTO;

public interface IChuyenBayService extends IBasic<ChuyenBayDTO>{
	
	List<ChuyenBayDTO> findAllByNgayGio(String ngayGio, Long id);
	List<ChuyenBayDTO> findChuyenBay(ChuyenBayDTO model);
	ChuyenBayDTO findOneChuyenBay(Long id, Long idVe);

}
