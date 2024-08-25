package com.nk.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nk.binding.ChildInputs;
import com.nk.binding.DcSummaryReport;
import com.nk.binding.EducationInputs;
import com.nk.binding.IncomeInputs;
import com.nk.binding.PlanSelectionInputs;
import com.nk.service.IDcMgmtService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/dc-api")
@Tag(name = "dc-api", description = "DataCollection Module Microservice")
public class DataCollectionOperationsController {
	@Autowired
	public IDcMgmtService dcService;
	
	@GetMapping("/planNames")
	public ResponseEntity<List<String>> displayPlanNames(){
		//use Service
		List<String> listPlanNames = dcService.showAllPlanNames();
		return new ResponseEntity<List<String>>(listPlanNames,HttpStatus.OK);
	}
	
	@PostMapping("/generateCaseNo/{appId}")
	public ResponseEntity<Integer> generateCaseNo(@PathVariable Long appId){
		//use Service
		Integer caseNo = dcService.generateCaseNo(appId);
		return  new ResponseEntity<Integer>(caseNo,HttpStatus.CREATED);
	}
	
	@PutMapping("/updatePlanSelection")
	public ResponseEntity<Integer> savePlanSelection(@RequestBody PlanSelectionInputs inputs){
		//use Service
		Integer caseNo = dcService.savePlanSelection(inputs);
		return new ResponseEntity<Integer>(caseNo,HttpStatus.OK);
	}
	
	@PostMapping("/saveIncome")
	public ResponseEntity<Integer> saveIncomeDetails(@RequestBody IncomeInputs income){
		//use service
		Integer caseNo = dcService.saveIncomeDetails(income);
		return new ResponseEntity<>(caseNo,HttpStatus.CREATED);
	}
	
	@PostMapping("/saveEducation")
	public ResponseEntity<Integer> saveEducationDetails(@RequestBody EducationInputs education){
		//use service
		Integer caseNo = dcService.saveEducationDetails(education);
		return new ResponseEntity<>(caseNo,HttpStatus.CREATED);
	}
	
	@PostMapping("/saveChilds")
	public ResponseEntity<Integer> saveChildrenDetails(@RequestBody List<ChildInputs> childs){
		//use caseNo
		Integer caseNo = dcService.saveChildrenDetails(childs);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.CREATED);
	}
	
	@GetMapping("/summary/{caseNo}")
	public ResponseEntity<DcSummaryReport> showSummaryReport(@PathVariable Integer caseNo){
		//use service
		DcSummaryReport report = dcService.showDCSummary(caseNo);
		return new ResponseEntity<DcSummaryReport>(report, HttpStatus.OK);
	}
}
