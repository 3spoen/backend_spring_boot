package de.spoen.backend_spring_boot;

import de.spoen.backend_spring_boot.service.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class ScurityConfig  {

    @Autowired
    private ApplicationUserDetailsService applicationUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        return httpSecurity
                //TODO: add CSRF security.
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry->{
           registry.requestMatchers("/home","registration/**").permitAll();
           registry.requestMatchers("/admin/**").hasRole("ADMIN");
            registry.requestMatchers("/user/**").hasRole("USER");
           registry.anyRequest().authenticated();
        }).formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();

    }

    @Bean
    public UserDetailsService userDetailsService(){

        return applicationUserDetailsService;
    }

//        UserDetails user= User.builder()
//                .username("gc")
//                .password("$2a$12$PpAotHzjQ.i0rO6eUY4oS.vEvpgIufM0TYRkdOqPaz5k8tAZSl.rq")
//                .roles("USER")
//                .build();
//
//        UserDetails admin= User.builder()
//                .username("admin")
//                .password("$2a$12$ZnMo7q83O/.1m84HJG/5hug8z3c6h7hG59zHFzSVXEiNDmXLYbgRS")
//                .roles("ADMIN","USER")
//                .build();
//        return new InMemoryUserDetailsManager(admin,user);
//    }


    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }



}
