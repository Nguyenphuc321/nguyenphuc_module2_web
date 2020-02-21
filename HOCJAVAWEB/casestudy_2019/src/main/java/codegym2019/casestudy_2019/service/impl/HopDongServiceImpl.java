package codegym2019.casestudy_2019.service.impl;


import codegym2019.casestudy_2019.entity.FuramaHopDong;
import codegym2019.casestudy_2019.repository.HopDongRepository;
import codegym2019.casestudy_2019.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HopDongServiceImpl implements HopDongService {
    @Autowired
    HopDongRepository hopDongRepository;


    @Override
    public Iterable<FuramaHopDong> getAllHopdong() {
        return hopDongRepository.findAll();
    }

    @Override
    public FuramaHopDong getHopdong(Long idHopDong) {
        return hopDongRepository.findById(idHopDong).orElse(null);
    }

    @Override
    public void saveHopdong(FuramaHopDong hopDong) {
        hopDongRepository.save(hopDong);

    }

    @Override
    public void deleteHopdong(Long idHopdong) {
        hopDongRepository.deleteById(idHopdong);

    }

    @Override
    public FuramaHopDong finById(Long id) {
        return finById(id);
    }
    @Override
    public Iterable<FuramaHopDong> findAllByIdKhachHang(Long id) {
        return hopDongRepository.findAllByIdkhachhang(id);
    }

}
