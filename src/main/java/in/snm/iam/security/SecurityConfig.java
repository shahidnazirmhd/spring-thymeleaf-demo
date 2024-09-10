package in.snm.iam.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// @EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    // private static final String[] WHITE_LIST_URL = {
    //         "/about/*",
    //         "/css/*",
    //         "/js/*",
    //         "/*",
    //         "index",
    //     };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        .authorizeHttpRequests((requests) -> requests
				.requestMatchers("/").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
    .sessionManagement((sessions) -> sessions
						.sessionConcurrency((concurrency) -> concurrency
								.maximumSessions(1)
								.maxSessionsPreventsLogin(true)
                                .expiredUrl("/login?expired")
						)
                        
				)
                // .sessionManagement((sessions) -> sessions
				// 		.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                //         .invalidSessionUrl("/logout?expired")
                //         .sessionFixation().newSession()
                //         .maximumSessions(1)
                //         .maxSessionsPreventsLogin(true)
    .logout((logout) -> logout
                .deleteCookies("JSESSIONID")
                .permitAll());

        return httpSecurity.build();
    }

}