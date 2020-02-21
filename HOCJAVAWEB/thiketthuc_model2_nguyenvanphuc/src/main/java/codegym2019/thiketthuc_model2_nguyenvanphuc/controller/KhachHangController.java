package codegym2019.thiketthuc_model2_nguyenvanphuc.controller;

import codegym2019.thiketthuc_model2_nguyenvanphuc.model.KhachHang;
import codegym2019.thiketthuc_model2_nguyenvanphuc.model.NhanVien;
import codegym2019.thiketthuc_model2_nguyenvanphuc.service.KhachHangService;
import codegym2019.thiketthuc_model2_nguyenvanphuc.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private NhanVienService nhanVienService;
    @ModelAttribute("nhanviens")
    public Iterable<NhanVien> nhanViens(){
        return nhanVienService.findAll();
    }

    @GetMapping("/khachhangs")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<KhachHang> khachhangs;
        if(s.isPresent()){
            khachhangs = khachHangService.findAllByHotenContaining(s.get(), pageable);
        } else {
            khachhangs = (Page<KhachHang>) khachHangService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/khachhang/list");
        modelAndView.addObject("khachhangs", khachhangs);
        return modelAndView;

    }

    @GetMapping("/create-khachhang")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/khachhang/create");
        modelAndView.addObject("khachhang", new KhachHang());
        return modelAndView;
    }

    @PostMapping("/create-khachhang")
    public ModelAndView saveCustomer(@ModelAttribute("khachhang") KhachHang khachHang){
        khachHangService.save(khachHang);
        ModelAndView modelAndView = new ModelAndView("/khachhang/create");
        modelAndView.addObject("khachhang", new KhachHang());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-khachhang/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        KhachHang khachHang = khachHangService.findById(id);
        if(khachHang != null) {
            ModelAndView modelAndView = new ModelAndView("/khachhang/edit");
            modelAndView.addObject("khachhang", khachHang);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-khachhang")
    public ModelAndView updateCustomer(@ModelAttribute("khachhang") KhachHang khachHang){
        khachHangService.save(khachHang);
        ModelAndView modelAndView = new ModelAndView("/khachhang/edit");
        modelAndView.addObject("khachhang", khachHang);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-khachhang/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        KhachHang khachHang = khachHangService.findById(id);
        if(khachHang != null) {
            ModelAndView modelAndView = new ModelAndView("/khachhang/delete");
            modelAndView.addObject("khachhang", khachHang);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-khachhang")
    public String deleteCustomer(@ModelAttribute("khachhang") KhachHang khachHang){
        khachHangService.remove(khachHang.getId());
        return "redirect:khachhangs";
    }
}
