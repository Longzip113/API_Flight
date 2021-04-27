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

import com.longnguyen.dto.ChucVuDTO;
import com.longnguyen.service.IBasic;

@RestController
public class ChucVuAPI {
	
	@Autowired
	IBasic<ChucVuDTO> chucVuService;
	
	@PostMapping(value = "/chucvu")
	public ChucVuDTO csaveChucVu(@RequestBody ChucVuDTO model) {
		return chucVuService.save(model);
	}
	
	@GetMapping(value = "/chucvu")
	public List<ChucVuDTO> getChucVu() {
		return chucVuService.findAll();
	}
	
	@PutMapping(value = "/chucvu")
	public ChucVuDTO updateChucVu(@RequestBody ChucVuDTO model) {
		return chucVuService.update(model);
	}
	
	@DeleteMapping(value = "/chucvu")
	public Boolean deleteSanBay(@RequestBody Long[] ids) {
		return chucVuService.delete(ids);
	}
	
	@GetMapping(value = "/chucvu/{id}")
	public ChucVuDTO getBySanBay(@PathVariable("id")Long id) {
		return chucVuService.findOne(id);
	}

}
