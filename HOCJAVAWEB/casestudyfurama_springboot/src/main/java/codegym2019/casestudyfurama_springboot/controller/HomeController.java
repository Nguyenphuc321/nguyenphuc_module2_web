package codegym2019.casestudyfurama_springboot.controller;

import codegym2019.casestudyfurama_springboot.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    DichVuService dichVuService;
    @GetMapping("/")
    public ModelAndView getHomepage(){
        dichVuService.getAllDichvu();
        return new ModelAndView("home/index","listdichvu",dichVuService.getAllDichvu());
    }
    @GetMapping("/dichvu/{id}")
    public ModelAndView getDichVuDetail(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("dichvu/dichvuchitiet");
        modelAndView.addObject("dichvuchitiet",dichVuService.getDichVu(id));
        return modelAndView;
    }
}
