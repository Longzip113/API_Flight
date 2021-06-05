package com.longnguyen.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.longnguyen.dto.KhachHangDTO;
import com.longnguyen.service.IBasic;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class KhachHangAPI {

	@Autowired
	IBasic<KhachHangDTO> service;
	
	@GetMapping(value = "/khachhang")
	public List<KhachHangDTO> getAll() {
		return service.findAll();
	}
	
	@PostMapping(value = "/khachhang")
	public KhachHangDTO save(@RequestBody KhachHangDTO model) {
		return service.save(model);
	}
	
	@PutMapping(value = "/khachhang")
	public KhachHangDTO update(@RequestBody KhachHangDTO model) {
		return service.update(model);
	}
	
	@DeleteMapping(value = "/khachhang/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}
	
	@GetMapping(value = "/khachhang/{id}")
	public KhachHangDTO getOne(@PathVariable("id")Long id) {
		return service.findOne(id);
	}
}
