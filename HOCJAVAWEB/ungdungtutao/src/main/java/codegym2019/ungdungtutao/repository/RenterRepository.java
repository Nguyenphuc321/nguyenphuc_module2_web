package codegym2019.ungdungtutao.repository;


import codegym2019.ungdungtutao.model.Renter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RenterRepository extends PagingAndSortingRepository<Renter,Long> {
    Iterable<Renter> findAllByProvince(Renter renter);

    Page<Renter> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
