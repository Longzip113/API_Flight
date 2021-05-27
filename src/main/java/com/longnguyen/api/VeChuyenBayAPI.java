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

import com.longnguyen.dto.VeChuyenBayDTO;
import com.longnguyen.service.IBasic;

@RestController
public class VeChuyenBayAPI {

	@Autowired
	IBasic<VeChuyenBayDTO> service;
	
	@GetMapping(value = "/vechuyenbay")
	public List<VeChuyenBayDTO> getAll() {
		return service.findAll();
	}
	
	@PostMapping(value = "/vechuyenbay")
	public VeChuyenBayDTO save(@RequestBody VeChuyenBayDTO model) {
		return service.save(model);
	}
	
	@PutMapping(value = "/vechuyenbay")
	public VeChuyenBayDTO update(@RequestBody VeChuyenBayDTO model) {
		return service.update(model);
	}
	
	@DeleteMapping(value = "/vechuyenbay/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}
	
	@GetMapping(value = "/vechuyenbay/{id}")
	public VeChuyenBayDTO getOne(@PathVariable("id")Long id) {
		return service.findOne(id);
	}

	
}
