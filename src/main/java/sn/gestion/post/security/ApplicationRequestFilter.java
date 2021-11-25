package sn.gestion.post.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Component
@Slf4j
public class ApplicationRequestFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
          throws ServletException, IOException {

    response.addHeader("Access-Control-Allow-Origin", "*");
    response.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, POST, PUT, DELETE");
    response.addHeader("Access-Control-Allow-Headers","Origin, Accept, X-Requested-With, Content-Type, " +"Access-Control-Request-Method, " +"Access-Control-Request-Headers, " + "Authorization");
    response.addHeader("Access-Control-Expose-Headers","Access-Control-Allow-Origin, " +"Access-Control-Allow-Credentials, " +"Authorization");
    if (request.getMethod().equals("OPTIONS")) {
      response.setStatus(HttpServletResponse.SC_OK);
    } else {

      String jwt = request.getHeader(SecurityConstants.HEADER_STRING);


      if (jwt == null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
        chain.doFilter(request, response);
        return;
      }
      try {
        String jwtToken = jwt.substring(7);
        Algorithm algorithm = Algorithm.HMAC256(SecurityConstants.SECRET);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(jwtToken);
        String username = decodedJWT.getSubject();
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, null);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);

      } catch (Exception e) {
        response.setHeader("error-message", e.getMessage());
        log.error(e.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
      }
    }
  }
}
