package com.management.staff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.staff.dto.StaffDetailDto;
import com.management.staff.service.StaffService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

	private StaffService staffService;
	
	@GetMapping("/getStaffBy/{joinYear}/{staffSalary}")
	public ResponseEntity<List<StaffDetailDto>> getStaffByYearAndSalary(@PathVariable int joinYear, @PathVariable double staffSalary){
		List<StaffDetailDto> staffDetails = staffService.getQualifiedStaff(joinYear, staffSalary);
		
		if (staffDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(staffDetails);
	}

	@GetMapping("/multiple-projects/{joinYear}/{staffSalary}")
	public ResponseEntity<List<StaffDetailDto>> getStaffIdsWithMultipleProjects(@PathVariable int joinYear, @PathVariable double staffSalary) {
		List<StaffDetailDto> staffIds = staffService.getStaffIdsWithMultipleProjects(joinYear, staffSalary);

		if (staffIds.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(staffIds, HttpStatus.OK);
	}
	
	
}
