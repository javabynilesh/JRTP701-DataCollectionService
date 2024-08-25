package com.nk.binding;

import java.util.List;

import lombok.Data;

@Data
public class DcSummaryReport { //5
	//private PlanSelectionInputs planDetails;
	private EducationInputs eduDetails;
	private List<ChildInputs> childrenDetails;
	private IncomeInputs incomeDetails;
	private CitizenAppRegistrationInputs citizenDetails;
	private String planName;
}
