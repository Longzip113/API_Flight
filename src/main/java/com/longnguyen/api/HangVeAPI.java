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

import com.longnguyen.dto.HangVeDTO;
import com.longnguyen.service.IBasic;

@RestController
public class HangVeAPI {

	@Autowired
	IBasic<HangVeDTO> service;
	
	@GetMapping(value = "/hangve")
	public List<HangVeDTO> getAll() {
		return service.findAll();
	}
	
	@PostMapping(value = "/hangve")
	public HangVeDTO save(@RequestBody HangVeDTO model) {
		return service.save(model);
	}
	
	@PutMapping(value = "/hangve")
	public HangVeDTO update(@RequestBody HangVeDTO model) {
		return service.update(model);
	}
	
	@DeleteMapping(value = "/hangve")
	public Boolean delete(@RequestBody Long[] ids) {
		return service.delete(ids);
	}
	
	@GetMapping(value = "/hangve/{id}")
	public HangVeDTO getOne(@PathVariable("id")Long id) {
		return service.findOne(id);
	}
	
}
