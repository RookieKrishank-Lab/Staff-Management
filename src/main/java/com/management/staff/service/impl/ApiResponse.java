package com.management.staff.service.impl;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private Long staffId;
    private List<Long> projectId;
}
