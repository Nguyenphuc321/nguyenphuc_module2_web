package codegym2019.khachhangdemo2.service;


import codegym2019.khachhangdemo2.model.KhachHang;

import java.util.List;

public interface KhachHangService {
    List<KhachHang> findAll();
    List<KhachHang> findAllByName(String name);
    KhachHang findById(int id);
    void save(KhachHang khachHang);
    void delete(KhachHang khachHang);
}
