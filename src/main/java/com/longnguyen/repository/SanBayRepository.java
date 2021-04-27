package com.longnguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.longnguyen.entity.SanBayEntity;

public interface SanBayRepository extends JpaRepository<SanBayEntity, Long>{
	SanBayEntity findByCode(String Code);
}
