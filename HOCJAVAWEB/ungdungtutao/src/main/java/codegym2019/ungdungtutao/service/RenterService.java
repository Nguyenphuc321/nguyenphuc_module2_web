package codegym2019.ungdungtutao.service;


import codegym2019.ungdungtutao.model.Renter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RenterService {
    Iterable<Renter> findAll();

    Page<Renter> findAll(Pageable pageable);

    Renter findById(Long id);

    void save(Renter renter);

    Page<Renter> findAllByFirstNameContaining(String firstname, Pageable pageable);

    void remove(Long id);

    Iterable<Renter> findAllByRenter(Renter renter);

}
