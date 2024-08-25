package com.nk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JR701_DC_INCOME") //2
@Data
public class DcIncomeEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer incomeId;
	private Integer caseNo;
	private Double empIncome;
	private Double propertyIncome;
}
