package codegym2019.casestudy_2019.service;


import codegym2019.casestudy_2019.entity.FuramaHopDong;



public interface HopDongService {
    public Iterable<FuramaHopDong> getAllHopdong();
    public FuramaHopDong getHopdong(Long idHopDong);
    public void saveHopdong(FuramaHopDong hopDong);
    public void deleteHopdong(Long idHopdong);
    FuramaHopDong finById(Long id);
    Iterable<FuramaHopDong> findAllByIdKhachHang(Long id);
}
