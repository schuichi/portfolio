package pl.tomekD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.tomekD.dao.UserProjectRepository;
import pl.tomekD.model.UserProject;

import java.util.Arrays;

@Service
public class UserProjectAuth implements UserDetailsService {

    @Autowired
    UserProjectRepository userProjectRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserProject userProject = userProjectRepository.findByUsername(username);

        if (userProject == null) throw new UsernameNotFoundException("Nie znaleziono użytkownika");

        GrantedAuthority authority = new SimpleGrantedAuthority(userProject.getRole());

        User springUser = new User(userProject.getUsername(), userProject.getPassword(), Arrays.asList(authority));

        UserDetails details = (UserDetails) springUser;

        return details;
    }
}
