package team.tp_acsi_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import team.tp_acsi_api.models.ERole;
import team.tp_acsi_api.models.Role;
import team.tp_acsi_api.models.User;
import team.tp_acsi_api.repositories.RoleRepository;
import team.tp_acsi_api.repositories.UserRepository;
import team.tp_acsi_api.requests.RegisterRequest;
import team.tp_acsi_api.responses.payloads.AuthResponsePayload;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private RoleRepository roleRepository; 
    private JwtService jwtService;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       JwtService jwtService,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository; 
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
    }

    public AuthResponsePayload loginUser(String email, String password) throws Exception {
        Optional<User> user = this.userRepository.findUserByEmail(email);
        if (!user.isPresent() || !passwordEncoder.matches(password, user.get().getPassword())) {
            throw new Exception("Wrong credentials");
        }
        String jwt = this.jwtService.generateToken(email);
        return new AuthResponsePayload(jwt, user.get());
    }

    public AuthResponsePayload registerUser(String email, String username, String password, String role) throws Exception {
        
        if (this.userRepository.findUserByEmail(email).isPresent()) {
            throw new Exception("Email already used");
        }
        
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        
        // Generate a JWT
        String jwt = this.jwtService.generateToken(email);
        return new AuthResponsePayload(jwt, user);
    }

    public Optional<User> verifyToken(HttpServletRequest req) throws Exception{
        final String jwt = req.getHeader("Authorization");
        if(jwt==null) {
            throw new Exception("Unauthorized");
        }
        try {
            String email = jwtService.getUsernameFromToken(jwt);
            Optional<User> user = userRepository.findUserByEmail(email);
            return user;

        } catch (Exception e) {
            throw new Exception("Unauthorized");
        }
    }

    
}
