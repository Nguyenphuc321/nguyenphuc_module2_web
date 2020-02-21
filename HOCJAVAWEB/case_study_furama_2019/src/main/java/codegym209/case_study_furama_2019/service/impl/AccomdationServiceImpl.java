package codegym209.case_study_furama_2019.service.impl;

import codegym209.case_study_furama_2019.model.Accomdation;
import codegym209.case_study_furama_2019.repository.AccomdationRepository;
import codegym209.case_study_furama_2019.service.AccomdationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccomdationServiceImpl implements AccomdationService {
    @Autowired
    private AccomdationRepository accomdationRepository;


    @Override
    public Page<Accomdation> findAll(Pageable pageable) {
        return accomdationRepository.findAll(pageable);
    }

    @Override
    public Accomdation findById(Long id) {
        return accomdationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Accomdation accomdation) {
        accomdationRepository.save(accomdation);
    }


    @Override
    public Page<Accomdation> findAllBykieuthueAccomdationContaining(String type, Pageable pageable) {
        return accomdationRepository.findAllByKieuthueContaining(type, pageable);
    }

    @Override
    public Page<Accomdation> findAllBytendichvuAccomdationContaining(String name, Pageable pageable) {
        return accomdationRepository.findAllByTendichvuContaining(name, pageable);
    }

    @Override
    public Page<Accomdation> findAllBychiphithueContaining(float price, Pageable pageable) {
        return accomdationRepository.findAllByChiphithueIs(price, pageable);
    }
}
