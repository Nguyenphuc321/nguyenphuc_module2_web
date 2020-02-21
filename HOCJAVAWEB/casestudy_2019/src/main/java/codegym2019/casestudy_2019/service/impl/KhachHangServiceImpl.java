package codegym2019.casestudy_2019.service.impl;


import codegym2019.casestudy_2019.entity.FuramaKhachHang;
import codegym2019.casestudy_2019.repository.KhachHangRepository;
import codegym2019.casestudy_2019.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    public Iterable<FuramaKhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public FuramaKhachHang getKhachhang(Long idKhachHang) {
        return khachHangRepository.findById(idKhachHang).orElse(null);
    }

    @Override
    public void saveKhachHang(FuramaKhachHang furamaKhachHang) {
        khachHangRepository.save(furamaKhachHang);

    }

    @Override
    public void deleteKhachHang(Long idKhachHang) {
        khachHangRepository.deleteById(idKhachHang);
    }
}
