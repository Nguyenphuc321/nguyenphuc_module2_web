package codegym2019.casestudy_2019.service;


import codegym2019.casestudy_2019.entity.FuramaHopDong;
import codegym2019.casestudy_2019.entity.FuramaKhachHang;

public interface KhachHangService {
    public Iterable<FuramaKhachHang> getAllKhachHang();
    public FuramaKhachHang getKhachhang(Long idKhachHang);
    public void saveKhachHang(FuramaKhachHang furamaKhachHang);
    public void deleteKhachHang(Long idKhachHang);
}
