package codegym2019.casestudy_2019.repository;


import codegym2019.casestudy_2019.entity.FuramaKhachHang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends CrudRepository<FuramaKhachHang,Long> {
}
