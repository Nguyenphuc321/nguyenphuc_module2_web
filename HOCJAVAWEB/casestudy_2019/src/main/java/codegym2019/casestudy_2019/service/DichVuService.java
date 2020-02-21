package codegym2019.casestudy_2019.service;

import codegym2019.casestudy_2019.entity.FuramaDichVu;



public interface DichVuService {
    public Iterable<FuramaDichVu> getAllDichvu();
    public FuramaDichVu getDichvu(Long idDichVu);
    public void saveDichVu(FuramaDichVu dichVu);
    public void deleteDichVu(Long idDichVu);
    FuramaDichVu finById(Long id);
    public Iterable<FuramaDichVu>findAllByChiphithueBetween(Integer fromfice,Integer toPice);
}
