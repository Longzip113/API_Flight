package com.longnguyen.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.longnguyen.entity.ChuyenBayEntity;

@Repository
public interface ChuyenBayRepository extends JpaRepository<ChuyenBayEntity, Long>{
	@Query(value = "select c.* from chuyenbay c where c.ngaygio <= :date and c.tuyenbay_id = :id", nativeQuery = true)
	List<ChuyenBayEntity> findAllByNgayGioAndTuyenBayEntity(@Param("date")Date date, @Param("id")Long id);
	
}
