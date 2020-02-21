package codegym2019.casestudy_2019.controller;


import codegym2019.casestudy_2019.entity.FuramaKhachHang;
import codegym2019.casestudy_2019.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;
    @GetMapping("/dangkykhachhang")
    public String getTrangdangky(Model model){
        model.addAttribute("khachhang",new FuramaKhachHang());
        return "trangdangky";
    }
    @PostMapping("/dangky")
    public String saveKhachhang(@Valid @ModelAttribute("khachhang")FuramaKhachHang furamaKhachHang, BindingResult bindingResult ){
        if (bindingResult.hasErrors()){
            return "trangdangky";
        }else {
            khachHangService.saveKhachHang(furamaKhachHang);
            return "dangkythanhcong";
        }
    }
}
