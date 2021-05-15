package com.longnguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.longnguyen.entity.TuyenBayEntity;

public interface TuyenBayRepository extends JpaRepository<TuyenBayEntity, Long>{
	@Query(value = "select c.* from tuyenbay c where c.sanbayden_id = :sanbayden_id and c.sanbaydi_id = :sanbaydi_id", nativeQuery = true)
	TuyenBayEntity findByIDDenAndIDDi(@Param("sanbayden_id")Long sanbayden_id, @Param("sanbaydi_id")Long sanbaydi_id);
}
