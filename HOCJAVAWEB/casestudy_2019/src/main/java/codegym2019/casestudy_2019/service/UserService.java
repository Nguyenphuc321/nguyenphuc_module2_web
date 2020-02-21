package codegym2019.casestudy_2019.service;


import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails loadUserByUsername(String username);

}
