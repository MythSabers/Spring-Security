package com.ui.application.application.Service;

import com.ui.application.application.dto.LoginRequest;
import com.ui.application.application.dto.RequestUser;
import com.ui.application.application.model.Authorities;
import com.ui.application.application.model.UserPrincipal;
import com.ui.application.application.model.Users;
import com.ui.application.application.repository.AuthoritiesRepository;
import com.ui.application.application.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> usersOptional = usersRepository.findUsersByUsername(username);
        if (usersOptional.isEmpty()) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        log.info("Username Found: " + usersOptional.get());

        Optional<Authorities> authoritiesOptional = authoritiesRepository.findAuthoritiesByUsername(username);
        if (authoritiesOptional.isEmpty()) {
            System.out.println("Authorities Not Found");
            throw new UsernameNotFoundException("invalid authorities not found");
        }
        log.info("Authorities Found: " + authoritiesOptional.get());

        return new UserPrincipal(usersOptional.get(), authoritiesOptional.get());
    }


    public boolean createUser(RequestUser user) {
        String password = encoder.encode(user.getPassword());
        Users users = Users.builder()
                .enabled(true)
                .password(password)
                .username(user.getUsername())
                .build();

        Authorities authorities = Authorities.builder()
                .username(user.getUsername())
                .role("ROLE_" + user.getRole())
                .build();

        usersRepository.saveAndFlush(users);
        authoritiesRepository.saveAndFlush(authorities);
        return true;
    }


}
