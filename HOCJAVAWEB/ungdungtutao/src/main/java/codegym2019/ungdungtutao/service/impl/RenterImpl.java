package codegym2019.ungdungtutao.service.impl;


import codegym2019.ungdungtutao.model.Renter;
import codegym2019.ungdungtutao.repository.RenterRepository;
import codegym2019.ungdungtutao.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RenterImpl implements RenterService {
    @Autowired
    RenterRepository renterRepository;


    @Override
    public Iterable<Renter> findAll() {
     return renterRepository.findAll();

    }

    @Override
    public Page<Renter> findAll(Pageable pageable) {
     return  renterRepository.findAll(pageable);

    }

    @Override
    public Renter findById(Long id) {
        return renterRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Renter renter) {
        renterRepository.save(renter);

    }

    @Override
    public Page<Renter> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return renterRepository.findAllByFirstNameContaining(firstname, pageable);
    }

    @Override
    public void remove(Long id) {
        renterRepository.deleteById(id);

    }

    @Override
    public Iterable<Renter> findAllByRenter(Renter renter) {
        return renterRepository.findAllByProvince(renter);
    }
}
