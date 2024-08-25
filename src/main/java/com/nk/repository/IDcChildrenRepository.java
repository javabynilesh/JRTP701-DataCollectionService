package com.nk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nk.entity.DcChildrenEntiy;

public interface IDcChildrenRepository extends JpaRepository<DcChildrenEntiy, Integer>{
	public List<DcChildrenEntiy> findByCaseNo(int caseNo);
}
