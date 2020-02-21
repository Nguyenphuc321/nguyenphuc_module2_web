package codegym2019.nguyenphuc_thiketthucmodel2.service;


import codegym2019.nguyenphuc_thiketthucmodel2.model.ThanhPho;

import java.util.List;

public interface ThanhPhoService {
    List<ThanhPho> findAll();
    List<ThanhPho> findAllByName(String name);
    ThanhPho findById(int id);
    void save(ThanhPho thanhPho);
    void delete(ThanhPho thanhPho);
}
