package com.longnguyen.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.longnguyen.dto.PhieuDatVeDTO;
import com.longnguyen.service.IBasic;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PhieuDatVeAPI {

	@Autowired
	IBasic<PhieuDatVeDTO> service;
	
	@GetMapping(value = "/phieudatve")
	public List<PhieuDatVeDTO> getAll() {
		return service.findAll();
	}
	
	
	@PutMapping(value = "/phieudatve")
	public PhieuDatVeDTO update(@RequestBody PhieuDatVeDTO model) {
		return service.update(model);
	}
	
	
	@GetMapping(value = "/phieudatve/{id}")
	public PhieuDatVeDTO getOne(@PathVariable("id")Long id) {
		return service.findOne(id);
	}
	
	@PostMapping(value = "/phieudatve")
	public PhieuDatVeDTO booking_ticket(@RequestBody PhieuDatVeDTO model) {
		return service.save(model);
	}
	
}
