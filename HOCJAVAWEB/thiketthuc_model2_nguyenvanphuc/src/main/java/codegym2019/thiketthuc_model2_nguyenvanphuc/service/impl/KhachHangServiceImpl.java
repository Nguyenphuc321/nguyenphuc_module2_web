package codegym2019.thiketthuc_model2_nguyenvanphuc.service.impl;

import codegym2019.thiketthuc_model2_nguyenvanphuc.model.KhachHang;
import codegym2019.thiketthuc_model2_nguyenvanphuc.model.NhanVien;
import codegym2019.thiketthuc_model2_nguyenvanphuc.repository.KhachHangRepository;
import codegym2019.thiketthuc_model2_nguyenvanphuc.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public Iterable<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public KhachHang findById(Long id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public void save(KhachHang khachHang) {
        khachHangRepository.save(khachHang);


    }

    @Override
    public Page<KhachHang> findAllByHotenContaining(String hoten, Pageable pageable) {
        return khachHangRepository.findAllByHotenContaining(hoten, pageable);
    }


    @Override
    public void remove(Long id) {
        khachHangRepository.deleteById(id);

    }

    @Override
    public Iterable<KhachHang> findAllByNhanVien(NhanVien nhanVien) {
        return khachHangRepository.findAllByNhanVien(nhanVien);
    }

}
