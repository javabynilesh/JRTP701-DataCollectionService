package com.nk.service;

import java.util.List;

import com.nk.binding.ChildInputs;
import com.nk.binding.DcSummaryReport;
import com.nk.binding.EducationInputs;
import com.nk.binding.IncomeInputs;
import com.nk.binding.PlanSelectionInputs;

public interface IDcMgmtService {
	//submit appid screen one
	//we should ge tcaseno and again we want to submit caseno an appid
	
	public Integer generateCaseNo(Long appId);
	public List<String> showAllPlanNames();
	public Integer savePlanSelection(PlanSelectionInputs plan);
	public Integer saveIncomeDetails(IncomeInputs income);
	public Integer saveEducationDetails(EducationInputs education);
	public Integer saveChildrenDetails(List<ChildInputs> children);
	public DcSummaryReport showDCSummary(Integer caseNo);
	
}
