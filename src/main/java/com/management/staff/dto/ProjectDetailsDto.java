package com.management.staff.dto;

import com.management.staff.entity.StaffDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDetailsDto {
    private Long projectId;
    private String projectName;
    private List<StaffDetails> staffDetails;

}
