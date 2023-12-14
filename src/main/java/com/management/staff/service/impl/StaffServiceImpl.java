package com.management.staff.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.management.staff.entity.ProjectDetails;
import org.springframework.stereotype.Service;

import com.management.staff.repository.StaffRepository;
import com.management.staff.service.StaffService;
import com.management.staff.dto.StaffDetailDto;
import com.management.staff.entity.StaffDetails;
import com.management.staff.mapper.StaffDetailsMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StaffServiceImpl implements StaffService{
	
	private StaffRepository staffRepository;

    public List<StaffDetailDto> getQualifiedStaff(int joinYear, double staffSalary) {
         List<StaffDetails> staffDetails = staffRepository.findByJoinYearAndStaffSalaryGreaterThan(joinYear, staffSalary);

         return staffDetails.stream().map(staffDetail -> StaffDetailsMapper.MAPPER.mapToStaffDetailsDto(staffDetail))
        		 .collect(Collectors.toList());
    }

    public List<StaffDetailDto> getStaffIdsWithMultipleProjects(int joinYear, double staffSalary) {
        List<StaffDetails> staffDetails = staffRepository.findByJoinYearAndStaffSalaryGreaterThan(joinYear, staffSalary);
        List<Long> list =staffRepository.findStaffIdsWithMultipleProjects();
        System.out.println(list);
        List<StaffDetails> newList = new ArrayList<>();
        for (StaffDetails i: staffDetails) {
            if(list.contains(i.getStaffId())){
                newList.add(i);
            }
        }
        return newList.stream().map(staffDetail -> StaffDetailsMapper.MAPPER.mapToStaffDetailsDto(staffDetail))
                .collect(Collectors.toList());
    }
}
