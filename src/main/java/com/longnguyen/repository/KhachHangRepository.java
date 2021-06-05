package com.longnguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.longnguyen.entity.KhachHangEntity;

public interface KhachHangRepository extends JpaRepository<KhachHangEntity, Long>{
	
	@Query(value = "select c.* from khachhang c where c.matkhau = :matkhau and c.email = :email" , nativeQuery = true)
	KhachHangEntity findByUserNameAndEmail(@Param("matkhau")String matkhau, @Param("email")String email);
	
	@Query(value = "select c.* from khachhang c where c.cmnd = :cmnd" , nativeQuery = true)
	KhachHangEntity findByCmnd(@Param("cmnd")String cmnd);
}
