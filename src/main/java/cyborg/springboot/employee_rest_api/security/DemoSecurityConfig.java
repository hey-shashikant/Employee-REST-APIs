package cyborg.springboot.employee_rest_api.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> 
            configurer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // use HTTP basic auth
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }


    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {

    //     UserDetails john = User.builder()
    //         .username("john")
    //         .password("{noop}1234five")
    //         .roles("EMPLOYEE")
    //         .build();

    //     UserDetails mary = User.builder()
    //         .username("mary")
    //         .password("{noop}1234five")
    //         .roles("EMPLOYEE", "MANAGER")
    //         .build();

    //     UserDetails susan = User.builder()
    //         .username("susan")
    //         .password("{noop}1234five")
    //         .roles("EMPLOYEE","MANAGER", "ADMIN")
    //         .build();
        
    //     return new InMemoryUserDetailsManager(john, mary, susan);
    // } 
}
