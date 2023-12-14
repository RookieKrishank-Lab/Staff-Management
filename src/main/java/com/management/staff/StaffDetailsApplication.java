package com.management.staff;

import com.management.staff.entity.ProjectDetails;
import com.management.staff.entity.StaffDetails;
import com.management.staff.repository.ProjectRepository;
import com.management.staff.repository.StaffRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class StaffDetailsApplication {

//	static ProjectDetails projectDetails = null;
	static StaffRepository usersRepository;
	static ProjectRepository projectRepository;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StaffDetailsApplication.class, args);

		usersRepository = context.getBean(StaffRepository.class);

		projectRepository = context.getBean(ProjectRepository.class);

        usersRepository.save(createUserObject1());
		usersRepository.save(createUserObject2());
}


	private static StaffDetails createUserObject1() {
		StaffDetails user = new StaffDetails();
		user.setJoinYear(2023);
		user.setStaffMail("ron@mail.com");
		user.setStaffName("ron");
		user.setStaffSalary(89000);

		List<ProjectDetails> roles = new ArrayList<>();
		ProjectDetails role = new ProjectDetails();
		role.setProjectId(52L);
		role.setProjectName("Darden");
		roles.add(role);
		System.out.println(roles);
		projectRepository.save(role);

		/*ProjectDetails role1 = new ProjectDetails();
		role1.setProjectId(891L);
		role1.setProjectName("Pepsi");
		roles.add(role1);
		projectRepository.save(role1);
		user.setProjectDetailsList(roles);
		System.out.println(roles);*/
		return user;
	}

	private static StaffDetails createUserObject2() {
		StaffDetails user = new StaffDetails();
		user.setJoinYear(2023);
		user.setStaffMail("bijay@mail.com");
		user.setStaffName("bijay");
		user.setStaffSalary(89000);

		List<ProjectDetails> roles = new ArrayList<>();
		ProjectDetails role = new ProjectDetails();
		role.setProjectId(672L);
		role.setProjectName("7Up");
		roles.add(role);
		System.out.println(roles);
		projectRepository.save(role);

		ProjectDetails role1 = new ProjectDetails();
		role1.setProjectId(891L);
		role1.setProjectName("Pepsi");
		roles.add(role1);
		projectRepository.save(role1);
		user.setProjectDetailsList(roles);
		System.out.println(roles);
		return user;
	}
}
