package com.nk.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ChildInputs {//4
	private Integer childId; //summary , we want all data
	private Integer caseNo;
	private LocalDate childDob;
	private Long childSSN;
}
