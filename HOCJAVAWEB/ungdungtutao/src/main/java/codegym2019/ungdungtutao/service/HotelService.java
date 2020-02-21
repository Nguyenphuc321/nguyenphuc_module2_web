package codegym2019.ungdungtutao.service;

import codegym2019.ungdungtutao.model.Hotel;

public interface HotelService {
    Iterable<Hotel> findAll();

    Hotel findById(Long id);

    void save(Hotel hotel);

    void remove(Long id);

}
