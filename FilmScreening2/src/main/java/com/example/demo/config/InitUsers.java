package com.example.demo.config;

import com.example.demo.model.Authority;
import com.example.demo.model.User;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InitUsers implements CommandLineRunner {
    
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    private void loadSecurityData() {
        
        Authority admin = authorityRepository.save(Authority.builder().role("ROLE_ADMIN").build());
        Authority userrole = authorityRepository.save(Authority.builder().role("ROLE_USER").build());
        Authority customer = authorityRepository.save(Authority.builder().role("ROLE_CUSTOMER").build());
        
        userRepository.save(User.builder().username("spring").password(passwordEncoder.encode("guru"))
                                    .authority(admin)
                                    .build());
        
        userRepository.save(User.builder().username("user3").password(passwordEncoder.encode("password"))
                                    .authority(userrole)
                                    .build());
        
        userRepository.save(User.builder().username("scott").password(passwordEncoder.encode("tiger"))
                                    .authority(customer)
                                    .build());
        
        
    }
    
    
    @Override
    public void run(String... args) throws Exception {
        loadSecurityData();
    }
    
}
