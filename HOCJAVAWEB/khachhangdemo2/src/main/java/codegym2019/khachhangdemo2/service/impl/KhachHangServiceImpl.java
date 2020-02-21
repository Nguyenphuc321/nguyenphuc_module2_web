package codegym2019.khachhangdemo2.service.impl;


import codegym2019.khachhangdemo2.model.KhachHang;
import codegym2019.khachhangdemo2.repository.KhachHangRepository;
import codegym2019.khachhangdemo2.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public List<KhachHang> findAllByName(String name) {
        return khachHangRepository.findAllByHotenLike(name);
    }

    @Override
    public KhachHang findById(int id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public void save(KhachHang khachHang) {
        khachHangRepository.save(khachHang);

    }

    @Override
    public void delete(KhachHang khachHang) {
        khachHangRepository.delete(khachHang);
    }
}
