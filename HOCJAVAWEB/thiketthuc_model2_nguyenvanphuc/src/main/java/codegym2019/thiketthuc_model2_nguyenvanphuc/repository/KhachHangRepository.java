package codegym2019.thiketthuc_model2_nguyenvanphuc.repository;


import codegym2019.thiketthuc_model2_nguyenvanphuc.model.KhachHang;
import codegym2019.thiketthuc_model2_nguyenvanphuc.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KhachHangRepository extends PagingAndSortingRepository<KhachHang,Long> {
    Iterable<KhachHang> findAllByNhanVien(NhanVien nhanVien);

    Page<KhachHang> findAllByHotenContaining(String hoten, Pageable pageable);

}
