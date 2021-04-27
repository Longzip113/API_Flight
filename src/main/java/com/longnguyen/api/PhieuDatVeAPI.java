package com.longnguyen.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.longnguyen.dto.PhieuDatVeDTO;
import com.longnguyen.service.IBasic;

@RestController
public class PhieuDatVeAPI {

	@Autowired
	IBasic<PhieuDatVeDTO> service;
	
	@GetMapping(value = "/phieudatve")
	public List<PhieuDatVeDTO> getAll() {
		return service.findAll();
	}
	
	@PostMapping(value = "/phieudatve")
	public PhieuDatVeDTO save(@RequestBody PhieuDatVeDTO model) {
		return service.save(model);
	}
	
	@PutMapping(value = "/phieudatve")
	public PhieuDatVeDTO update(@RequestBody PhieuDatVeDTO model) {
		return service.update(model);
	}
	
	@DeleteMapping(value = "/phieudatve")
	public Boolean delete(@RequestBody Long[] ids) {
		return service.delete(ids);
	}
	
	@GetMapping(value = "/phieudatve/{id}")
	public PhieuDatVeDTO getOne(@PathVariable("id")Long id) {
		return service.findOne(id);
	}
	
}
