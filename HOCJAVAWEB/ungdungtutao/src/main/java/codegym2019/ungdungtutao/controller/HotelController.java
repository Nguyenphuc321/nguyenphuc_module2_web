package codegym2019.ungdungtutao.controller;

import codegym2019.ungdungtutao.model.Hotel;
import codegym2019.ungdungtutao.model.Renter;
import codegym2019.ungdungtutao.service.HotelService;
import codegym2019.ungdungtutao.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @GetMapping("/hotels")
    public ModelAndView listProvinces(){
        Iterable<Hotel> hotels = hotelService.findAll();
        ModelAndView modelAndView = new ModelAndView("/hotel/list");
        modelAndView.addObject("hotels",hotels);
        return modelAndView;
    }

    @GetMapping("/create-hotel")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/hotel/create");
        modelAndView.addObject("hotel", new Hotel());
        return modelAndView;
    }

    @PostMapping("/create-hotel")
    public ModelAndView saveProvince(@ModelAttribute("hotel") Hotel hotel){
        hotelService.save(hotel);

        ModelAndView modelAndView = new ModelAndView("/hotel/create");
        modelAndView.addObject("hotel", new Hotel());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-hotel/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Hotel hotel = hotelService.findById(id);
        if(hotel != null) {
            ModelAndView modelAndView = new ModelAndView("/hotel/edit");
            modelAndView.addObject("hotel",hotel);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-hotel")
    public ModelAndView updateProvince(@ModelAttribute("hotel") Hotel hotel){
        hotelService.save(hotel);
        ModelAndView modelAndView = new ModelAndView("/hotel/edit");
        modelAndView.addObject("hotel", hotel);
        modelAndView.addObject("message", "Hotel updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Hotel hotel = hotelService.findById(id);
        if (hotel != null) {
            ModelAndView modelAndView = new ModelAndView("/hotel/delete");
            modelAndView.addObject("hotel",hotel);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-hotel")
    public String deleteProvince(@ModelAttribute("hotel") Hotel hotel){
        hotelService.remove(hotel.getId());
        return "redirect:hotels";
    }
    @ModelAttribute("hotels")
    public Iterable<Hotel> hotels(){
        return hotelService.findAll();
    }
    @Autowired
    private RenterService renterService;

    @GetMapping("/view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Renter renter = renterService.findById(id);
        if(renter == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Renter> renters = renterService.findAllByRenter(renter);

        ModelAndView modelAndView = new ModelAndView("/renter/view");
        modelAndView.addObject("renter",renter);
        modelAndView.addObject("hotels",hotels());
        return modelAndView;
    }
}
