package com.management.staff.repository;

import java.util.List;

import com.management.staff.service.impl.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import com.management.staff.entity.StaffDetails;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepository extends JpaRepository<StaffDetails, Long>{
	 List<StaffDetails> findByJoinYearAndStaffSalaryGreaterThan(int joinYear, double staffSalary);
	@Query("SELECT s.staffId FROM StaffDetails s JOIN s.projectDetailsList p GROUP BY s.staffId HAVING COUNT(p) > 1")
	List<Long> findStaffIdsWithMultipleProjects();

	/*@Query("SELECT p.projectId FROM StaffDetails s JOIN s.projectDetailsList p GROUP BY s.staffId, p.projectId HAVING COUNT(p) > 1")
	List<Long> findStaffIdsWithMultipleProjects();*/

	/*@Query("SELECT p.projectId FROM StaffDetails s JOIN s.projectDetailsList p GROUP BY p.projectId HAVING COUNT(s.staffId) > 1")
	List<Long> findProjectsIdsWithMultipleStaff();*/


	/*@Query("SELECT p.projectId FROM projectDetailsList p JOIN p.StaffDetails s GROUP BY s.staffId HAVING COUNT(p)>1")
	List<Long> findProjectsIdsWithMultipleStaff();*/

	/*@Query("SELECT p.projectId FROM ProjectDetails p JOIN p.staffDetailsList s GROUP BY s.staffId HAVING COUNT(p) > 1")
	List<Long> findProjectsIdsWithMultipleStaff();*/

}
