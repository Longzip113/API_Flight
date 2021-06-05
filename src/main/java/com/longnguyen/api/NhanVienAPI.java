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

import com.longnguyen.dto.NhanVienDTO;
import com.longnguyen.service.IBasic;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class NhanVienAPI {

	@Autowired
	IBasic<NhanVienDTO> nhanVienService;
	
	@GetMapping(value = "/nhanvien")
	public List<NhanVienDTO> getAll() {
		return nhanVienService.findAll();
	}
	
	@PostMapping(value = "/nhanvien")
	public NhanVienDTO save(@RequestBody NhanVienDTO model) {
		return nhanVienService.save(model);
	}
	
	@PutMapping(value = "/nhanvien")
	public NhanVienDTO update(@RequestBody NhanVienDTO model) {
		return nhanVienService.update(model);
	}
	
	@DeleteMapping(value = "/nhanvien/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return nhanVienService.delete(id);
	}
	
	@GetMapping(value = "/nhanvien/{id}")
	public NhanVienDTO getOne(@PathVariable("id")Long id) {
		return nhanVienService.findOne(id);
	}
}
