package codegym2019.casestudy_2019.repository;


import codegym2019.casestudy_2019.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
}
