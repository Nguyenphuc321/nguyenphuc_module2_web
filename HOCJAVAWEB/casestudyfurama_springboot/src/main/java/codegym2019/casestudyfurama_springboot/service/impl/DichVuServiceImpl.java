package codegym2019.casestudyfurama_springboot.service.impl;


import codegym2019.casestudyfurama_springboot.entity.FuramaDichVu;
import codegym2019.casestudyfurama_springboot.repository.DichVuRepository;
import codegym2019.casestudyfurama_springboot.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DichVuServiceImpl implements DichVuService {
    @Autowired
    DichVuRepository dichVuRepository;


    @Override
    public Iterable<FuramaDichVu> getAllDichvu() {
        return dichVuRepository.findAll();

    }

    @Override
    public Optional<FuramaDichVu> getDichVu(Long idDichVu) {
        return dichVuRepository.findById(idDichVu);
    }

    @Override
    public void saveDichVu(FuramaDichVu dichVu) {
        dichVuRepository.save(dichVu);

    }

    @Override
    public void deleteDichVu(Long idDichVu) {
        dichVuRepository.deleteById(idDichVu);
    }
}
