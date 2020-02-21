package codegym2019.thiketthuc_model2_nguyenvanphuc.service;

import codegym2019.thiketthuc_model2_nguyenvanphuc.model.KhachHang;
import codegym2019.thiketthuc_model2_nguyenvanphuc.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhachHangService {
    Iterable<KhachHang> findAll();

    Page<KhachHang> findAll(Pageable pageable);

    KhachHang findById(Long id);

    void save(KhachHang khachHang);

    Page<KhachHang> findAllByHotenContaining(String hoten, Pageable pageable);

    void remove(Long id);

    Iterable<KhachHang> findAllByNhanVien(NhanVien nhanVien);
}
