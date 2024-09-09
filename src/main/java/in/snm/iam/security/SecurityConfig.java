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
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// @EnableMethodSecurity(securedEnabled = true)
@EnableJdbcHttpSession
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
        .requestMatchers("/", "/home").permitAll()
        .anyRequest().authenticated()
    )
    .formLogin((form) -> form
        .loginPage("/login")
        .defaultSuccessUrl("/hello", true)
        .permitAll()
    )
    .sessionManagement(session -> session
    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
            .invalidSessionUrl("/logout?expired")
            .maximumSessions(1)
            .maxSessionsPreventsLogin(true)
        )
    .logout((logout) -> logout
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll());

        return httpSecurity.build();
    }
}
