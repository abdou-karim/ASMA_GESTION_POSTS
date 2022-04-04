package sn.gestion.post.controller.Api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.gestion.post.model.auth.AuthenticationRequest;
import sn.gestion.post.model.auth.AuthenticationResponse;

public interface AuthenticationApi {

  @PostMapping("/login")
  ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);

}
