package com.management.staff.mapper;

import com.management.staff.dto.ProjectDetailsDto;
import com.management.staff.entity.ProjectDetails;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectDetailsMapper {

    ProjectDetailsMapper PROJECT_DETAILS_MAPPER = Mappers.getMapper(ProjectDetailsMapper.class);

    ProjectDetails mapToProjectDetails(ProjectDetailsDto projectDetailsDto);

    ProjectDetailsDto mapToProjectDetailsDto(ProjectDetails projectDetails);
}
