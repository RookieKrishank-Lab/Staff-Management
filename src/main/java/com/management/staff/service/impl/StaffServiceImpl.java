package com.management.staff.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.management.staff.entity.ProjectDetails;
import com.management.staff.repository.ProjectRepository;
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
    private ProjectRepository projectRepository;

    /*public StaffDetailDto addStaffDetails(StaffDetailDto staffDetailDto) {
        StaffDetails staffDetails = StaffDetailsMapper.MAPPER.mapToStaffDetails(staffDetailDto);
        StaffDetails saveStaffDetails = staffRepository.save(staffDetails);
        return StaffDetailsMapper.MAPPER.mapToStaffDetailsDto(saveStaffDetails);
    }*/

    public StaffDetailDto addStaffDetails(StaffDetailDto staffDetailDto) {
        StaffDetails staffDetails = StaffDetailsMapper.MAPPER.mapToStaffDetails(staffDetailDto);
        // Save projects if they don't exist
        saveProjectsIfNotExist(staffDetails.getProjectDetailsList());

        // Save the staff member
        StaffDetails saveStaffDetails = staffRepository.save(staffDetails);
        return StaffDetailsMapper.MAPPER.mapToStaffDetailsDto(saveStaffDetails);
    }

    private void saveProjectsIfNotExist(List<ProjectDetails> projects) {
        for (ProjectDetails project : projects) {
            // Check if the project with the given projectId already exists
            Optional<ProjectDetails> existingProject = projectRepository.findById(project.getProjectId());

            // If the project doesn't exist, save it
            existingProject.ifPresentOrElse(
                    (p) -> {},
                    () -> projectRepository.save(project)
            );
        }
    }

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

    /*public List<StaffDetailDto> findStaffByConditions(int joinYear, double staffSalary, int projectCount) {
        List<StaffDetails> staffList = staffRepository.findByJoinYearAndStaffSalaryGreaterThanAndProjectDetailsListIsNotEmptyAndProjectDetailsListSizeGreaterThan(joinYear, staffSalary, projectCount);
        return staffList.stream().map(staffDetail -> StaffDetailsMapper.MAPPER.mapToStaffDetailsDto(staffDetail))
                .collect(Collectors.toList());
    }*/
    public List<StaffDetailDto> findStaffByConditions(int joinYear, double staffSalary, int projectCount) {
        List<StaffDetails> staffList = staffRepository.findStaffByConditions(joinYear, staffSalary, projectCount);
        return staffList.stream().map(staffDetail -> StaffDetailsMapper.MAPPER.mapToStaffDetailsDto(staffDetail))
                .collect(Collectors.toList());
    }
}
