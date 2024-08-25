package com.nk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nk.binding.ChildInputs;
import com.nk.binding.CitizenAppRegistrationInputs;
import com.nk.binding.DcSummaryReport;
import com.nk.binding.EducationInputs;
import com.nk.binding.IncomeInputs;
import com.nk.binding.PlanSelectionInputs;
import com.nk.entity.CitizenAppRegistrationEntity;
import com.nk.entity.DcCaseEntity;
import com.nk.entity.DcChildrenEntity;
import com.nk.entity.DcEducationEntity;
import com.nk.entity.DcIncomeEntity;
import com.nk.entity.PlanEntity;
import com.nk.repository.IApplicationRegistrationRepository;
import com.nk.repository.IDcCaseRepository;
import com.nk.repository.IDcChildrenRepository;
import com.nk.repository.IDcEducationRepository;
import com.nk.repository.IDcIncomeRepository;
import com.nk.repository.IPlanRepository;

@Service
public class DcMgmtServiceImpl implements IDcMgmtService {
	@Autowired
	private IDcCaseRepository caseRepo;
	@Autowired
	private IApplicationRegistrationRepository citizenAppRepo;
	@Autowired
	private IDcIncomeRepository incomeRepo;
	@Autowired
	private IPlanRepository planRepo;
	@Autowired
	private IDcEducationRepository educationRepo;
	@Autowired
	private IDcChildrenRepository childrenRepo;

	@Override
	public Integer generateCaseNo(Long appId) {
		// load citizen data
		Optional<CitizenAppRegistrationEntity> appCitizen = citizenAppRepo.findById(appId);
		if (appCitizen.isPresent()) {
			DcCaseEntity caseEntity = new DcCaseEntity();
			caseEntity.setAppId(appId);
			return caseRepo.save(caseEntity).getCaseNo(); // save obj operation
		}
		return 0;
	}

	@Override
	public List<String> showAllPlanNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer savePlanSelection(PlanSelectionInputs plan) {
		// load DcCaseEntity object
		Optional<DcCaseEntity> opt = caseRepo.findById(plan.getCaseNo());
		if (opt.isPresent()) {
			DcCaseEntity caseEntity = opt.get();
			caseEntity.setPlanId(plan.getPlanId());
			// update the DcCaseEntity with plaN Id
			caseRepo.save(caseEntity); // update obj operation
			return caseEntity.getCaseNo();
		}
		return 0;
	}

	@Override
	public Integer saveIncomeDetails(IncomeInputs income) {
		// Convert binding obj data to entity class obj data
		DcIncomeEntity incomeEntity = new DcIncomeEntity();
		BeanUtils.copyProperties(income, incomeEntity);
		// save the income details
		incomeRepo.save(incomeEntity);
		// return caseNo
		return income.getCaseNo();
	}

	@Override
	public Integer saveEducationDetails(EducationInputs education) {
		// convert binding obj to entity obj
		DcEducationEntity educationEntity = new DcEducationEntity();
		BeanUtils.copyProperties(education, educationEntity);
		// save obj
		educationRepo.save(educationEntity);
		// return the caseNumber
		return education.getCaseNo();
	}

	@Override
	public Integer saveChildrenDetails(List<ChildInputs> children) {
		// convert each binding class obj to each entity class obj
		children.forEach(child -> {
			DcChildrenEntity childEntiy = new DcChildrenEntity();
			BeanUtils.copyProperties(child, childEntiy);
			// save each eanity obj
			childrenRepo.save(childEntiy);
		});
		// return caseNo
		return children.get(0).getCaseNo();
	}

	@Override
	public DcSummaryReport showDCSummary(Integer caseNo) {
		// get multiple entity obj based on caseNo
		DcIncomeEntity incomeEnitity = incomeRepo.findByCaseNo(caseNo);
		DcEducationEntity educationEntity = educationRepo.findByCaseNo(caseNo);
		List<DcChildrenEntity> childEntityList = childrenRepo.findByCaseNo(caseNo);
		Optional<DcCaseEntity> optCaseEntity = caseRepo.findById(caseNo);
		String planName = null;
		Long appId = null;
		if (optCaseEntity.isPresent()) {
			DcCaseEntity caseEntity = optCaseEntity.get();
			Integer planId = caseEntity.getPlanId();
			appId = caseEntity.getAppId();
			Optional<PlanEntity> optPlanEntity = planRepo.findById(planId);
			if (optPlanEntity.isPresent()) {
				planName = optPlanEntity.get().getPlanName();
			}
		}
		
		Optional<CitizenAppRegistrationEntity> optCitizenEntity = citizenAppRepo.findById(appId);
		CitizenAppRegistrationEntity citizenEntity = null;
		if(optCitizenEntity.isPresent()) {
			citizenEntity = optCitizenEntity.get();
		}
		
		//convert entity obj to binding object
		IncomeInputs income = new IncomeInputs();
		BeanUtils.copyProperties(incomeEnitity, income);
		
		EducationInputs education = new EducationInputs();
		BeanUtils.copyProperties(educationEntity, education);
		
		List<ChildInputs> listChilds = new ArrayList<>();
		childEntityList.forEach((childEntity)->{
			ChildInputs child = new ChildInputs();
			BeanUtils.copyProperties(childEntity, child);
			listChilds.add(child);
		});
		
		CitizenAppRegistrationInputs  citizen = new CitizenAppRegistrationInputs();
		BeanUtils.copyProperties(citizenEntity, citizen);
		
		//prepare DCSummaryReport obj
		DcSummaryReport report  =new DcSummaryReport();
		report.setPlanName(planName);
		report.setIncomeDetails(income);
		report.setEduDetails(education);
		report.setCitizenDetails(citizen);
		report.setChildrenDetails(listChilds);
		return report;
	}

}
