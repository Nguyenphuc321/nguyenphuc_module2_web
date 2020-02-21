package codegym2019.casestudy_2019.service.impl;


import codegym2019.casestudy_2019.entity.FuramaDichVu;
import codegym2019.casestudy_2019.repository.DichVuRepository;
import codegym2019.casestudy_2019.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DichVuServiceImpl implements DichVuService {
    @Autowired
    DichVuRepository dichVuRepository;


    @Override
    public Iterable<FuramaDichVu> getAllDichvu() {
        return dichVuRepository.findAll();

    }

    @Override
    public FuramaDichVu getDichvu(Long idDichVu) {
        return dichVuRepository.findById(idDichVu).orElse(null);
    }

    @Override
    public void saveDichVu(FuramaDichVu dichVu) {
        dichVuRepository.save(dichVu);

    }

    @Override
    public void deleteDichVu(Long idDichVu) {
        dichVuRepository.deleteById(idDichVu);
    }

    @Override
    public FuramaDichVu finById(Long id) {
        return dichVuRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<FuramaDichVu> findAllByChiphithueBetween(Integer fromfice, Integer toPice) {
        return dichVuRepository.findAllByChiphithueBetween(fromfice, toPice);
    }
}
