package codegym2019.ungdungtutao.controller;


import codegym2019.ungdungtutao.model.Hotel;
import codegym2019.ungdungtutao.model.Renter;
import codegym2019.ungdungtutao.service.HotelService;
import codegym2019.ungdungtutao.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class RenterController {
    @Autowired
    private RenterService renterService;

    @Autowired
    private HotelService hotelService;

    @ModelAttribute("renters")
    public Iterable<Hotel>  hotels(){
        return hotelService.findAll();
    }

    @GetMapping("/renters")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Renter> renters;
        if(s.isPresent()){
            renters = renterService.findAllByFirstNameContaining(s.get(), pageable);
        } else {
            renters = (Page<Renter>) renterService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/renter/list");
        modelAndView.addObject("renters",renters);
        return modelAndView;

    }

    @GetMapping("/create-renter")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/renter/create");
        modelAndView.addObject("renter",new Renter());
        return modelAndView;
    }

    @PostMapping("/create-renter")
    public ModelAndView saveCustomer(@ModelAttribute("renter") Renter renter){
        renterService.save(renter);
        ModelAndView modelAndView = new ModelAndView("/renter/create");
        modelAndView.addObject("renter",new Renter());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-renter/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Renter renter = renterService.findById(id);
        if(renter != null) {
            ModelAndView modelAndView = new ModelAndView("/renter/edit");
            modelAndView.addObject("renter",renter);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-renter")
    public ModelAndView updateRenter(@ModelAttribute("renter") Renter renter){
        renterService.save(renter);
        ModelAndView modelAndView = new ModelAndView("/renter/edit");
        modelAndView.addObject("renter",renter);
        modelAndView.addObject("message", "Renter updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-renter/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Renter renter = renterService.findById(id);
        if(renter != null) {
            ModelAndView modelAndView = new ModelAndView("/renter/delete");
            modelAndView.addObject("renter",renter);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-renter")
    public String deleteCustomer(@ModelAttribute("renter") Renter renter){
        renterService.remove(renter.getId());
        return "redirect:renters";
    }
}
