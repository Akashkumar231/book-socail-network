package com.alibou.book.auth;

import com.alibou.book.role.RoleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private RoleRepository roleRepository;

    public void register( RegistrationRequest request) {
      var userRole = roleRepository
    }
}
