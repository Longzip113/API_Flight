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

import com.longnguyen.dto.TuyenBayDTO;
import com.longnguyen.service.IBasic;

@RestController
public class TuyenBayAPI {
	
	
	@Autowired
	IBasic<TuyenBayDTO> service;
	
	@PostMapping(value = "/tuyenbay")
	public TuyenBayDTO save(@RequestBody TuyenBayDTO model) {
		return service.save(model);
	}
	
	@GetMapping(value = "/tuyenbay")
	public List<TuyenBayDTO> get() {
		return service.findAll();
	}
	
	@PutMapping(value = "/tuyenbay")
	public TuyenBayDTO update(@RequestBody TuyenBayDTO model) {
		return service.update(model);
	}
	
	@DeleteMapping(value = "/tuyenbay")
	public Boolean delete(@RequestBody Long[] ids) {
		return service.delete(ids);
	}
	
	@GetMapping(value = "/tuyenbay/{id}")
	public TuyenBayDTO getOne(@PathVariable("id")Long id) {
		return service.findOne(id);
	}

}
