package in.snm.iam;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import in.snm.iam.role.Role;
import in.snm.iam.role.RoleRepository;
import in.snm.iam.user.User;
import in.snm.iam.user.UserRepository;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class IamApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (roleRepository.findByName("ADMIN").isEmpty()) {
				roleRepository.save(Role.builder().name("ADMIN").build());
			}
			var userRole =
        roleRepository.findByName("ADMIN")
                //TODO:Make exception handling better
                .orElseThrow(() -> new NoSuchElementException("Role USER was not initialized"));
    var user =
        User.builder()
            .firstname("Shahid Nazir")
            .lastname("Zaheer Husain")
            .email("admin@example.com")
            .password(passwordEncoder.encode("123"))
            .accountLocked(false)
            .enabled(true)
            .roles(List.of(userRole))
            .build();
    	userRepository.save(user);

		};
	}

}
