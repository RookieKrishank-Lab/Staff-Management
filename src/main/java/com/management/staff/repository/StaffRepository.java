package com.management.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.staff.entity.StaffDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StaffRepository extends JpaRepository<StaffDetails, Long>{

	//Method to find staff member whose join year is 2023 and salary is greater than 30000 from staff table
	List<StaffDetails> findByJoinYearAndStaffSalaryGreaterThan(int joinYear, double staffSalary);

	//Method to get those staff id whose project id count is greater than 1
	// from the staff_project table
	@Query("SELECT s.staffId FROM StaffDetails s JOIN s.projectDetailsList p GROUP BY s.staffId HAVING COUNT(p) > 1")
	List<Long> findStaffIdsWithMultipleProjects();

//	List<StaffDetails> findByJoinYearAndStaffSalaryGreaterThanAndProjectDetailsListIsNotEmptyAndProjectDetailsListSizeGreaterThan(int joinYear, double staffSalary, int projectCount);

	@Query("SELECT s FROM StaffDetails s WHERE s.joinYear = :joinYear AND s.staffSalary > :staffSalary AND (SELECT COUNT(p) FROM s.projectDetailsList p) > :projectCount")
	List<StaffDetails> findStaffByConditions(@Param("joinYear") int joinYear, @Param("staffSalary") double staffSalary, @Param("projectCount") int projectCount);

}