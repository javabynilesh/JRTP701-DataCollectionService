package com.nk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nk.entity.DcIncomeEntity;

public interface IDcIncomeRepository extends JpaRepository<DcIncomeEntity, Integer>{
	public DcIncomeEntity findByCaseNo(int caseNo);
}
