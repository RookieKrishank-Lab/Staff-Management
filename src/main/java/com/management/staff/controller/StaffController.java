package com.management.staff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.management.staff.dto.StaffDetailDto;
import com.management.staff.service.StaffService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

	private StaffService staffService;

	@PostMapping("/add")
	public ResponseEntity<StaffDetailDto> addStaff(@RequestBody StaffDetailDto staffDetailDto) {
		StaffDetailDto staffDetails = staffService.addStaffDetails(staffDetailDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(staffDetails);
	}
	
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

	@GetMapping("/search/{joinYear}/{staffSalary}/{projectCount}")
	public ResponseEntity<List<StaffDetailDto>> searchStaff(
			@PathVariable int joinYear,
			@PathVariable double staffSalary,
			@PathVariable int projectCount) {

		List<StaffDetailDto> result = staffService.findStaffByConditions(joinYear, staffSalary, projectCount);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
