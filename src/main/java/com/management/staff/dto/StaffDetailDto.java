package com.management.staff.dto;

import com.management.staff.entity.ProjectDetails;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffDetailDto {
	private Long staffId;
	private String staffName;
	private String staffMail;
	private double staffSalary;
	private int joinYear;
	private List<ProjectDetails> projectDetailsList;

}
