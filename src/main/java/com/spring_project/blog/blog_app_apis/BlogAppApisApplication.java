package com.spring_project.blog.blog_app_apis;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring_project.blog.blog_app_apis.config.AppConstants;
import com.spring_project.blog.blog_app_apis.entities.Role;
import com.spring_project.blog.blog_app_apis.entities.RoleRepo;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

    @Bean
    ModelMapper modelMapper(){
		return new ModelMapper();
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.print("sample token is : ");
		System.out.println(this.passwordEncoder.encode("abc"));
		System.out.println();
		System.out.println();
		System.out.println();
		

		try {
			Role role1 = new Role();
			role1.setId(AppConstants.ADMIN);
			role1.setName("ADMIN_USER");

			Role role2 = new Role();
			role2.setId(AppConstants.NORMAL);
			role2.setName("NORMAL_USER");

			List<Role> roles = List.of(role1,role2);

			this.roleRepo.saveAll(roles);



		} catch (Exception e) {
			 
		}
	}

}
