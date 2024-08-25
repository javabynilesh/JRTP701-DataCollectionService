package com.nk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nk.entity.DcEducationEntity;

public interface IDcEducationRepository extends JpaRepository<DcEducationEntity, Integer>{
	public DcEducationEntity findByCaseNo(int caseNo);
}
