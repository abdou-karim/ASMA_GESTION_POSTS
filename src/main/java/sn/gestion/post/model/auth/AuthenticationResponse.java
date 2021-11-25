package sn.gestion.post.model.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthenticationResponse {

  private String accessToken;
}
