package codegym2019.khachhangdemo2.repository;

import codegym2019.khachhangdemo2.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {
    List<KhachHang> findAllByHotenLike(String name);
    KhachHang findAllById(int id);

}
