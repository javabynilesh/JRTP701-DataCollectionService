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

import com.nk.binding.PlanSelectionInputs;
import com.nk.service.IDcMgmtService;

@RestController
@RequestMapping("/dc-api")
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
		return  new ResponseEntity<Integer>(caseNo,HttpStatus.OK);
	}
	
	@PutMapping("/updatePlanSelection")
	public ResponseEntity<Integer> savePlanSelection(@RequestBody PlanSelectionInputs inputs){
		//use Service
		Integer caseNo = dcService.savePlanSelection(inputs);
		return new ResponseEntity<Integer>(caseNo,HttpStatus.OK);
	}
	
}
