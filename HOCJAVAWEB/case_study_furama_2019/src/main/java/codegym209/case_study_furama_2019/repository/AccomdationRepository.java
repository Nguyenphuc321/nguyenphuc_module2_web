package codegym209.case_study_furama_2019.repository;

import codegym209.case_study_furama_2019.model.Accomdation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomdationRepository extends PagingAndSortingRepository<Accomdation, Long> {
    Page<Accomdation> findAll(Pageable pageable);
    Page<Accomdation> findAllByChiphithueIs(float price, Pageable pageable);
    Page<Accomdation> findAllByTendichvuContaining(String name, Pageable pageable);
    Page<Accomdation> findAllByKieuthueContaining(String type, Pageable pageable);

}
