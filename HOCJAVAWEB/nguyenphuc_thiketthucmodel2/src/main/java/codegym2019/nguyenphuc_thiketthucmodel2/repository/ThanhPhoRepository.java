package codegym2019.nguyenphuc_thiketthucmodel2.repository;

import codegym2019.nguyenphuc_thiketthucmodel2.model.ThanhPho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThanhPhoRepository extends JpaRepository<ThanhPho,Integer> {
    List<ThanhPho> findAllByTenthanhphoLike(String name);
    ThanhPho findAllById(int id);

}
