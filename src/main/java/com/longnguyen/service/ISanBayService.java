package com.longnguyen.service;

import com.longnguyen.dto.SanBayDTO;

public interface ISanBayService extends IBasic<SanBayDTO>{
	SanBayDTO findByCode(String code);
}
