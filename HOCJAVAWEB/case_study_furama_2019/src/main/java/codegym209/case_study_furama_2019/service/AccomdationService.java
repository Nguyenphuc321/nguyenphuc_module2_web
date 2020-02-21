package codegym209.case_study_furama_2019.service;

import codegym209.case_study_furama_2019.model.Accomdation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccomdationService {
    Page<Accomdation> findAll(Pageable pageable);

    Accomdation findById(Long id);

    void save(Accomdation accomdation);

//    Page<Accomdation> findAll(Pageable pageable);

    Page<Accomdation> findAllBykieuthueAccomdationContaining(String type, Pageable pageable);

    Page<Accomdation> findAllBytendichvuAccomdationContaining(String name, Pageable pageable);

    Page<Accomdation> findAllBychiphithueContaining(float price, Pageable pageable);

}
