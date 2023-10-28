package br.com.demtech.controller;

import br.com.demtech.domain.entity.User;
import br.com.demtech.domain.repository.UserRepository;
import br.com.demtech.dto.ResponseStandard;
import br.com.demtech.dto.user.AuthenticationDTO;
import br.com.demtech.dto.user.RegisterDTO;
import br.com.demtech.exceptions.UserException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

/**
 *
 * @author Mateus Dantas
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity login(@Valid @RequestBody AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity register(@Valid @RequestBody RegisterDTO data) {
        if (userRepository.findByEmail(data.email()).isPresent()) {
            throw new UserException("erro", "E-mail já está em uso");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.email(), encryptedPassword, data.role());

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
