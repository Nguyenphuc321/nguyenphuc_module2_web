package codegym2019.casestudy_2019.repository;


import codegym2019.casestudy_2019.entity.FuramaHopDong;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongRepository extends PagingAndSortingRepository<FuramaHopDong,Long> {
    Iterable<FuramaHopDong> findAllByIdkhachhang(Long id);
}
