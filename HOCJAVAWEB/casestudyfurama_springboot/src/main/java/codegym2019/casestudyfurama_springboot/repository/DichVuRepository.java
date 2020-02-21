package codegym2019.casestudyfurama_springboot.repository;

import codegym2019.casestudyfurama_springboot.entity.FuramaDichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DichVuRepository extends PagingAndSortingRepository<FuramaDichVu,Long> {
    Page<FuramaDichVu> findAll(Pageable pageable);

}
