package com.longnguyen.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.longnguyen.dto.KhachHangDTO;
import com.longnguyen.service.IKhachHangService;

@RestController
public class Login {

	@Autowired
	IKhachHangService service;
	
	@PostMapping(value = "/login")
	public KhachHangDTO login(@RequestBody KhachHangDTO model) {
		return service.login(model);
	}
}
