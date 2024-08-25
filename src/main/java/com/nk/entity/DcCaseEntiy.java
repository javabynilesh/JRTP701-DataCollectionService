package com.nk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JR701_DC_CASES") //1
@Data
public class DcCaseEntiy {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		//private Long caseId;
		private Integer caseNo;
		private Long appId;
		private Integer planId;
}
