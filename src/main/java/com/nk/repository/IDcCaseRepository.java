package com.nk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nk.entity.DcCaseEntiy;

public interface IDcCaseRepository extends JpaRepository<DcCaseEntiy, Integer>{
	public Integer findByCaseNo(int caseNo);
	
}
