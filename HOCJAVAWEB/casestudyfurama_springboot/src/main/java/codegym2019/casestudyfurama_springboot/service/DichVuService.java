package codegym2019.casestudyfurama_springboot.service;

import codegym2019.casestudyfurama_springboot.entity.FuramaDichVu;

import java.util.Optional;


public interface DichVuService {
    public Iterable<FuramaDichVu> getAllDichvu();
    public Optional<FuramaDichVu> getDichVu(Long idDichVu);
    public void saveDichVu(FuramaDichVu dichVu);
    public void deleteDichVu(Long idDichVu);
}
