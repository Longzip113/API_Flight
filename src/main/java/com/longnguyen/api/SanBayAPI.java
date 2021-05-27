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

import com.longnguyen.dto.SanBayDTO;
import com.longnguyen.service.ISanBayService;

@CrossOrigin(origins = "http://localhost:3000")
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
	
	@DeleteMapping(value = "/sanbay/{id}")
	public Boolean deleteSanBay(@PathVariable("id") Long id) {
		return sanBayService.delete(id);
	}
	
	@GetMapping(value = "/sanbay/{id}")
	public SanBayDTO getByID(@PathVariable("id")Long id) {
		return sanBayService.findOne(id);
	}
}
