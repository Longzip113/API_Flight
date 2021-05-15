package com.longnguyen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.longnguyen.entity.VeChuyenBayEntity;

public interface VeChuyenBayRepository extends JpaRepository<VeChuyenBayEntity, Long>{

	@Query(value = "select c.* from vechuyenbay c where c.chuyenbay_id = :id", nativeQuery = true)
	List<VeChuyenBayEntity> findByIDChuyenBay(@Param("id")Long id);
	
}
