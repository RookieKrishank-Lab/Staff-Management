package com.management.staff.repository;

import com.management.staff.entity.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectDetails, Long> {


}
