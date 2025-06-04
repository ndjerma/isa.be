package com.example.demo.configuration;

import com.example.demo.repositories.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationConfiguration {
    private final IUserRepository userRepository;

    public ApplicationConfiguration(IUserRepository userRepository) { this.userRepository = userRepository; }

        //Kada se neko pokušava ulogovati, Spring koristi ovaj servis da proveri da li korisnik postoji u bazi.
    @Bean
    UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
        //Kada korisnik unese lozinku, Spring će koristiti ovaj encoder da uporedi enkriptovanu lozinku iz baze i plaintext lozinku iz forme.
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
        //Ovo Spring koristi u AuthenticationService kad treba da "pokuša login", da proveri da li su kredencijali validni.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
        //Ovaj provider koristi UserDetailsService da pronađe korisnika i BCryptPasswordEncoder da proveri lozinku.
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}
