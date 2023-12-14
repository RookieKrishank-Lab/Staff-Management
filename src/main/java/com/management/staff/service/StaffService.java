package com.management.staff.service;

import java.util.List;

import com.management.staff.dto.StaffDetailDto;

public interface StaffService {
	public List<StaffDetailDto> getQualifiedStaff(int joinYear, double staffSalary);
	public List<StaffDetailDto> getStaffIdsWithMultipleProjects(int joinYear, double staffSalary);
}
