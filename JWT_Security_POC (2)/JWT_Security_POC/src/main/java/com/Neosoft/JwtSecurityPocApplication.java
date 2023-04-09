package com.Neosoft;

import com.Neosoft.model.Role;
import com.Neosoft.payloads.AppConstants;
import com.Neosoft.repository.RoleRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class JwtSecurityPocApplication implements CommandLineRunner {

	Logger logger= LoggerFactory.getLogger(JwtSecurityPocApplication.class);

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityPocApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	}

	@Override
	public void run(String... args) throws Exception {

		try {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

			Role role2=new Role();
			role2.setId(AppConstants.MODERATE_USER);
			role2.setName("MODERATE_USER");

			List<Role> roles = List.of(role, role1,role2);

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r -> {
				System.out.println(r.getName());
			});
		} catch (Exception e) {
			logger.error("Exception while trying to read data. {}" + e.getMessage());
		}


	}
}
