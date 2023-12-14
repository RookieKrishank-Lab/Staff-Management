package com.management.staff.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="staff")
public class StaffDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long staffId;
	private String staffName;
	@Email
	private String staffMail;
	private double staffSalary;
	private int joinYear;
//	@Transient
	@ManyToMany
	@JoinTable(
			name = "staff_project",											//3rd  table name
			joinColumns = @JoinColumn(name = "staff_id"),
			inverseJoinColumns = @JoinColumn(name = "project_id")
	)
	private List<ProjectDetails> projectDetailsList;
}
