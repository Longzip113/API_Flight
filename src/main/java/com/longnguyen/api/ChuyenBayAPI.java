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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.longnguyen.dto.ChuyenBayDTO;
import com.longnguyen.service.IChuyenBayService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ChuyenBayAPI {
	
	@Autowired
	IChuyenBayService service;
	
	@GetMapping(value = "/chuyenbay")
	public List<ChuyenBayDTO> getAll() {
		return service.findAll();
	}
	
	@PostMapping(value = "/chuyenbay")
	public ChuyenBayDTO save(@RequestBody ChuyenBayDTO model) {
		return service.save(model);
	}
	
	@PutMapping(value = "/chuyenbay")
	public ChuyenBayDTO update(@RequestBody ChuyenBayDTO model) {
		return service.update(model);
	}
	
	@DeleteMapping(value = "/chuyenbay/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}
	
	@GetMapping(value = "/chuyenbay/{id}/{idVe}")
	public ChuyenBayDTO getOne(@PathVariable("id")Long id, @PathVariable("idVe")Long idVe) {
		return service.findOneChuyenBay(id, idVe);
	}
	
	@GetMapping(value = "/chuyenbays/{idtuyenbay}/{ngaygio}")
	public List<ChuyenBayDTO> getOneByDate(@PathVariable("ngaygio")String ngayGio,@PathVariable("idtuyenbay")Long id) {
		return service.findAllByNgayGio(ngayGio, id);
	}
	
	@PostMapping(value = "/search-chuyenbay")
	@ResponseBody
	public List<ChuyenBayDTO> searchChuyenBay(@RequestBody ChuyenBayDTO model) {
		return service.findChuyenBay(model);
	}
	
}
