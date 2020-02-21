package codegym2019.thiketthuc_model2_nguyenvanphuc.service;


import codegym2019.thiketthuc_model2_nguyenvanphuc.model.NhanVien;

public interface NhanVienService {
    Iterable<NhanVien> findAll();

    NhanVien findById(Long id);

    void save(NhanVien nhanVien);

    void remove(Long id);

}
