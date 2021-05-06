package com.longnguyen.service;

import com.longnguyen.dto.KhachHangDTO;

public interface IKhachHangService extends IBasic<KhachHangDTO>{
	
	KhachHangDTO login(KhachHangDTO khachHangDTO);

}
