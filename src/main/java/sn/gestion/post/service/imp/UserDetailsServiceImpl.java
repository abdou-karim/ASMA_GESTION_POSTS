package sn.gestion.post.service.imp;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sn.gestion.post.model.Utilisateur;
import sn.gestion.post.service.ApplicationService;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsServiceImpl")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private ApplicationService applicationService;

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Utilisateur utilisateur = applicationService.findByUsername(username);
        if (utilisateur !=null){
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            return new User(utilisateur.getUsername(),utilisateur.getPassword(),authorities);
        }
        else {
            throw new UsernameNotFoundException(username);
        }
    }
}
