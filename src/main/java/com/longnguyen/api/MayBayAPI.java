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

import com.longnguyen.dto.MayBayDTO;
import com.longnguyen.service.IBasic;

@RestController
public class MayBayAPI {

	@Autowired
	IBasic<MayBayDTO> mayBayService;
	
	@GetMapping(value = "/maybay")
	public List<MayBayDTO> getAll() {
		List<MayBayDTO> listmayBayDTOs = mayBayService.findAll();
		return listmayBayDTOs;
	}
	
	@PostMapping(value = "/maybay")
	public MayBayDTO save(@RequestBody MayBayDTO model) {
		MayBayDTO sanBayDTO = mayBayService.save(model);
		return sanBayDTO;
	}
	
	@PutMapping(value = "/maybay")
	public MayBayDTO update(@RequestBody MayBayDTO model) {
		MayBayDTO sanBayDTO = mayBayService.update(model);
		return sanBayDTO;
	}
	
	@DeleteMapping(value = "/maybay")
	public Boolean delete(@RequestBody Long[] ids) {
		return mayBayService.delete(ids);
	}
	
	@GetMapping(value = "/maybay/{id}")
	public MayBayDTO getOne(@PathVariable("id")Long id) {
		return mayBayService.findOne(id);
	}
	
}
