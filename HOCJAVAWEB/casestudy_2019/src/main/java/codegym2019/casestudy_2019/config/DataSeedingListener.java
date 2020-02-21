package codegym2019.casestudy_2019.config;

import codegym2019.casestudy_2019.entity.Role;
import codegym2019.casestudy_2019.entity.User;
import codegym2019.casestudy_2019.repository.RoleRepository;
import codegym2019.casestudy_2019.repository.UserRepository;
import codegym2019.casestudy_2019.utils.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (roleRepository.findByName("ROLE ADMIN") ==null){
            roleRepository.save(new Role("ROLE_ADMIN"));
        }
        if (roleRepository.findByName("ROLE MEMBER") ==null){
            roleRepository.save(new Role("ROLE_MEMBER"));
        }
        //them admin
        if (userRepository.findByEmail("admin@gmail")==null){
            User admin = new User();
            admin.setEmail("admin@gmail");
            admin.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }
        //them member
        if (userRepository.findByEmail("member@gmail")==null){
            User user = new User();
            user.setEmail("member@gmail");
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }

    }
}
