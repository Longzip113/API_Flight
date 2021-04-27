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

import com.longnguyen.dto.SanBayDTO;
import com.longnguyen.service.ISanBayService;

@RestController
public class SanBayAPI {
	
	@Autowired
	ISanBayService sanBayService;
	
	@GetMapping(value = "/sanbay")
	public List<SanBayDTO> getSanBay() {
		List<SanBayDTO> listSanBayDTOs = sanBayService.findAll();
		return listSanBayDTOs;
	}
	
	@PostMapping(value = "/sanbay")
	public SanBayDTO saveSanBay(@RequestBody SanBayDTO model) {
		SanBayDTO sanBayDTO = sanBayService.save(model);
		return sanBayDTO;
	}
	
	@PutMapping(value = "/sanbay")
	public SanBayDTO updateSanBay(@RequestBody SanBayDTO model) {
		SanBayDTO sanBayDTO = sanBayService.save(model);
		return sanBayDTO;
	}
	
	@DeleteMapping(value = "/sanbay")
	public Boolean deleteSanBay(@RequestBody Long[] ids) {
		return sanBayService.delete(ids);
	}
	
	@GetMapping(value = "/sanbay/{id}")
	public SanBayDTO getBySanBay(@PathVariable("id")Long id) {
		return sanBayService.findOne(id);
	}
	
	@GetMapping(value = "/sanbay/{code}")
	public SanBayDTO getBySanBay(@PathVariable("code")String code) {
		return sanBayService.findByCode(code);
	}
	

}
