package com.nk.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JR701_PLAN_MASTER") //5
@Data
public class PlanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planId;
	@Column(length=30)
	private String planName;
	private LocalDate startDate;
	private LocalDate endDate;
	@Column(length=50)
	private String description;
	private Integer categoryId;
	//@Column(name="ACTIVE_SW", length=15)
	private String activeSw; 
	@Column(name="CREATION_DATE",updatable = false)
	@CreationTimestamp
	private LocalDateTime creationDate;
	@Column(name="UPDATION_DATE",updatable = true, insertable = false)
	@UpdateTimestamp
	private LocalDateTime updationDate;
	@Column(name="CREATED_BY",length=30)
	private String createdBy;
	@Column(name="UPDATED_BY",length=30)
	private String updatedBy;
}
