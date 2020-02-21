package codegym2019.nguyenphuc_thiketthucmodel2.service.impl;


import codegym2019.nguyenphuc_thiketthucmodel2.model.ThanhPho;
import codegym2019.nguyenphuc_thiketthucmodel2.repository.ThanhPhoRepository;
import codegym2019.nguyenphuc_thiketthucmodel2.service.ThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThanhPhoServiceImpl implements ThanhPhoService {
    @Autowired
    private ThanhPhoRepository thanhPhoRepository;
    @Override
    public List<ThanhPho> findAll() {
        return thanhPhoRepository.findAll();
    }

    @Override
    public List<ThanhPho> findAllByName(String name) {
        return thanhPhoRepository.findAllByTenthanhphoLike(name);
    }

    @Override
    public ThanhPho findById(int id) {
        return thanhPhoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ThanhPho thanhPho) {
        thanhPhoRepository.save(thanhPho);

    }

    @Override
    public void delete(ThanhPho thanhPho) {
        thanhPhoRepository.delete(thanhPho);
    }
}
