package codegym2019.casestudy_2019.repository;

import codegym2019.casestudy_2019.entity.FuramaDichVu;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DichVuRepository extends PagingAndSortingRepository<FuramaDichVu,Long> {
    Iterable<FuramaDichVu> findAllByChiphithueBetween(Integer fromfice,Integer toPrice);
}
