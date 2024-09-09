package in.snm.iam;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import in.snm.iam.user.Role;
import in.snm.iam.user.User;
import in.snm.iam.user.UserRepository;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class IamApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            return args -> {
                var user =
        User.builder()
            .firstname("Shahid Nazir")
            .lastname("Zaheer Husain")
            .email("admin@app.this")
            .password(passwordEncoder.encode("123"))
            .role(Role.ADMIN)
            .build();
    	userRepository.save(user);
            };
	}
}
 
