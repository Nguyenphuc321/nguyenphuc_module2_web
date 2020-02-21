package codegym2019.casestudy_2019.controller;

import codegym2019.casestudy_2019.entity.FuramaDichVu;
import codegym2019.casestudy_2019.entity.FuramaFavorite;
import codegym2019.casestudy_2019.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("favorite")
@Controller
public class HomeController {
    @Autowired
    DichVuService dichVuService;
    @GetMapping("/")
    public ModelAndView getHomepage(@RequestParam(value = "fromPrice",required = false)Integer fromPrice,
                                    @RequestParam(value = "toPrice",required = false)Integer toPrice)
    {
        ModelAndView modelAndView = new ModelAndView("home");
        if (fromPrice == null|| toPrice == null){
            modelAndView.addObject("listdichvu",dichVuService.getAllDichvu());
        }else {
            modelAndView.addObject("listdichvu",dichVuService.findAllByChiphithueBetween(fromPrice, toPrice));
        }

        return modelAndView;
    }
    @GetMapping("/details/{id}")
    public ModelAndView detailAccomdation(@PathVariable Long id){
        FuramaDichVu furamaDichVu = dichVuService.finById(id);
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("dichvu",furamaDichVu);
        return modelAndView;
    }
    @GetMapping("/villa")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("villa");
        modelAndView.addObject("dichvuvilla", new FuramaDichVu());
        return modelAndView;
    }

    @PostMapping("/villa")
    public ModelAndView saveCustomer(@ModelAttribute("dichvuvilla") FuramaDichVu furamaDichVu){
        dichVuService.saveDichVu(furamaDichVu);
        ModelAndView modelAndView = new ModelAndView("villa");
        modelAndView.addObject("dichvuvilla", new FuramaDichVu());
        modelAndView.addObject("message", "New villa created successfully");
        return modelAndView;
    }
    @ModelAttribute("favorite")
    public FuramaFavorite setupSession(){
        return new FuramaFavorite();
    }
    @GetMapping("/favorite/{id}")
    public String saveSessionFavorite(@PathVariable("id")Long id,@ModelAttribute("favorite")FuramaFavorite sessionFavorite){
        sessionFavorite.add(dichVuService.getDichvu(id));
        return "redirect:/";
    }
    @GetMapping("/favoritePage")
    public String getFavoritepage(){
        return "favorite";
    }
//    @GetMapping("/user")
//    public ModelAndView showForm() {
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("user", new User());
//        return modelAndView;
//    }
//
//    @PostMapping("/validateUser")
//    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
//        if (bindingResult.hasFieldErrors()) {
//            ModelAndView modelAndView = new ModelAndView("index");
//            return modelAndView;
//        }
//        ModelAndView modelAndView = new ModelAndView("result");
//        return modelAndView;
//    }
}
