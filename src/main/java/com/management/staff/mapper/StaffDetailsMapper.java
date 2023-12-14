package com.management.staff.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.management.staff.dto.StaffDetailDto;
import com.management.staff.entity.StaffDetails;

@Mapper
public interface StaffDetailsMapper {

	StaffDetailsMapper MAPPER = Mappers.getMapper(StaffDetailsMapper.class);
	
	StaffDetailDto mapToStaffDetailsDto(StaffDetails staffDetails);
	
	StaffDetails mapToStaffDetails(StaffDetailDto staffDetailDto);
}
