package com.nk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nk.entity.PlanEntity;

public interface IPlanRepository extends JpaRepository<PlanEntity, Integer>{

}
