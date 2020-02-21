package codegym2019.casestudy_2019.repository;

import codegym2019.casestudy_2019.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByName(String name);
}
