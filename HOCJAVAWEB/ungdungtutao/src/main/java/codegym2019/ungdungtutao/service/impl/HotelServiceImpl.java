package codegym2019.ungdungtutao.service.impl;


import codegym2019.ungdungtutao.model.Hotel;
import codegym2019.ungdungtutao.repository.HotelRepository;
import codegym2019.ungdungtutao.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Iterable<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);

    }

    @Override
    public void remove(Long id) {
        hotelRepository.deleteById(id);
    }
}
