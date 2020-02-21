package codegym2019.thiketthuc_model2_nguyenvanphuc.service.impl;


import codegym2019.thiketthuc_model2_nguyenvanphuc.model.NhanVien;
import codegym2019.thiketthuc_model2_nguyenvanphuc.repository.NhanVienRepository;
import codegym2019.thiketthuc_model2_nguyenvanphuc.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public Iterable<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien findById(Long id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public void save(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);

    }

    @Override
    public void remove(Long id) {
        nhanVienRepository.deleteById(id);

    }
}
