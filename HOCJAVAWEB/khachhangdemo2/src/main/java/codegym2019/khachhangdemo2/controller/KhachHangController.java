package codegym2019.khachhangdemo2.controller;

import codegym2019.khachhangdemo2.model.KhachHang;
import codegym2019.khachhangdemo2.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<KhachHang> khachHangList = khachHangService.findAll();
        modelAndView.addObject("listKhachHang",khachHangList);
        return modelAndView;
    }

    @GetMapping("/find-kh")
    public ModelAndView findKh(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView("index");
        List<KhachHang> listKhachHang = khachHangService.findAllByName(name);
        modelAndView.addObject("listKhachHang",listKhachHang);
        return modelAndView;
    }

    @GetMapping("/edit-kh/{id}")
    public ModelAndView getEdit(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        KhachHang khachHang = khachHangService.findById(id);
        modelAndView.addObject("khachhang",khachHang);
        return modelAndView;
    }

    @PostMapping("/edit-kh")
    public ModelAndView saveKH(@ModelAttribute("khachhang") KhachHang khachHang){
        khachHangService.save(khachHang);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("message","Bạn đã cập nhật thành công");
        return modelAndView;
    }

    @GetMapping("/delete-kh/{id}")
    public ModelAndView getDelete(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        KhachHang khachHang = khachHangService.findById(id);
        modelAndView.addObject("khachhang",khachHang);
        return modelAndView;
    }
    @PostMapping("/delete-kh")
    public ModelAndView deleteKH(@ModelAttribute("khachhang") KhachHang khachHang){
        khachHangService.delete(khachHang);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("message","Bạn đã xóa thành công");
        return modelAndView;
    }

    @GetMapping("/new-kh")
    public ModelAndView getDelete(){
        ModelAndView modelAndView = new ModelAndView("new");
        modelAndView.addObject("khachhang",new KhachHang());
        return modelAndView;
    }

//    @PostMapping("/create-kh")
//    public ModelAndView createKH(@ModelAttribute("khachhang") KhachHang khachHang){
//        ModelAndView modelAndView = new ModelAndView("redirect:/");
//        khachHangService.save(khachHang);
//        modelAndView.addObject("message","Thành công");
//        return modelAndView;
//    }
@PostMapping("/create-kh")
public ModelAndView checkValidation(@Validated @ModelAttribute("khachhang") KhachHang khachHang, BindingResult bindingResult) {
    if (bindingResult.hasFieldErrors()) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        khachHangService.save(khachHang);
        modelAndView.addObject("message","thànhcông");
        return modelAndView;
    }
    ModelAndView modelAndView = new ModelAndView("result");
    return modelAndView;
}
}
