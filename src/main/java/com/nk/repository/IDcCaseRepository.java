package com.nk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nk.entity.DcCaseEntity;

public interface IDcCaseRepository extends JpaRepository<DcCaseEntity, Integer>{
	public Integer findByCaseNo(int caseNo);
	
}
