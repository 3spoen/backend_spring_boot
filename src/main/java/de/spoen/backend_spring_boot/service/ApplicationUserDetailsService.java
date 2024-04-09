package de.spoen.backend_spring_boot.service;

import de.spoen.backend_spring_boot.model.ApplicationUsers;
import de.spoen.backend_spring_boot.repo.ApplicationUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private ApplicationUsersRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUsers> theuser = repo.findByname(username);
        if(theuser.isPresent()){

            var userObj = theuser.get();
            return User.builder()
                    .username(userObj.getName())
                    .password(userObj.getPassword())
                    .roles(wichRole(userObj))
                    .build();

        }else {
            throw  new UsernameNotFoundException(username);
        }
    }

    private String [] wichRole(ApplicationUsers userObj) {
        if (userObj.getRole()==null){
            return new String[] {"user"};
        }
        return userObj.getRole().split(",");
    }
}
