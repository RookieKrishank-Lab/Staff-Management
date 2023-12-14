package com.management.staff.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="project")
public class ProjectDetails {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String projectName;
/*
    @ManyToMany(mappedBy = "projectDetailsList")
    private List<StaffDetails> staffDetails;
*/

}
