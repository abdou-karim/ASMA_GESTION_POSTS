package sn.gestion.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import sn.gestion.post.controller.Api.AuthenticationApi;
import sn.gestion.post.model.auth.AuthenticationRequest;
import sn.gestion.post.model.auth.AuthenticationResponse;
import sn.gestion.post.repository.UtilisateurRepository;
import sn.gestion.post.service.imp.UserDetailsServiceImpl;
import sn.gestion.post.utils.JwtUtil;


@RestController
@AllArgsConstructor
public class AuthController implements AuthenticationApi {
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsService;
    private JwtUtil jwtUtil;
    UtilisateurRepository userRepository;

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        final String jwt = jwtUtil.generateToken((User) userDetails);

        return ResponseEntity.ok(
                new AuthenticationResponse(jwt)
        );
    }
}
