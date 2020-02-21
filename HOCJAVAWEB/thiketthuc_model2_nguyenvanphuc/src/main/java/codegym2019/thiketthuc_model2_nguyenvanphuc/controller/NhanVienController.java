package codegym2019.thiketthuc_model2_nguyenvanphuc.controller;

import codegym2019.thiketthuc_model2_nguyenvanphuc.model.KhachHang;
import codegym2019.thiketthuc_model2_nguyenvanphuc.model.NhanVien;
import codegym2019.thiketthuc_model2_nguyenvanphuc.service.KhachHangService;
import codegym2019.thiketthuc_model2_nguyenvanphuc.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/nhanviens")
    public ModelAndView listProvinces(){
        Iterable<NhanVien> nhanViens = nhanVienService.findAll();
        ModelAndView modelAndView = new ModelAndView("/nhanvien/list");
        modelAndView.addObject("nhanviens",nhanViens);
        return modelAndView;
    }

    @GetMapping("/create-nhanvien")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/nhanvien/create");
        modelAndView.addObject("nhanvien", new NhanVien());
        return modelAndView;
    }

    @PostMapping("/create-nhanvien")
    public ModelAndView saveProvince(@ModelAttribute("nhanvien") NhanVien nhanVien){
        nhanVienService.save(nhanVien);

        ModelAndView modelAndView = new ModelAndView("/nhanvien/create");
        modelAndView.addObject("nhanvien", new NhanVien());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-nhanvien/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        NhanVien nhanVien = nhanVienService.findById(id);
        if(nhanVien != null) {
            ModelAndView modelAndView = new ModelAndView("/nhanvien/edit");
            modelAndView.addObject("nhanvien", nhanVien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-nhanvien")
    public ModelAndView updateProvince(@ModelAttribute("nhanvien") NhanVien nhanVien){
        nhanVienService.save(nhanVien);
        ModelAndView modelAndView = new ModelAndView("/nhanvien/edit");
        modelAndView.addObject("nhanvien", nhanVien);
        modelAndView.addObject("message", "NhanVien updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-nhanvien/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        NhanVien nhanVien = nhanVienService.findById(id);
        if (nhanVien != null) {
            ModelAndView modelAndView = new ModelAndView("/nhanvien/delete");
            modelAndView.addObject("nhanvien", nhanVien);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-nhanvien")
    public String deleteProvince(@ModelAttribute("nhanvien") NhanVien nhanVien){
        nhanVienService.remove(nhanVien.getId());
        return "redirect:nhanviens";
    }
    @ModelAttribute("nhanviens")
    public Iterable<NhanVien> nhanViens(){
        return nhanVienService.findAll();
    }
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/view-nhanvien/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        NhanVien nhanVien = nhanVienService.findById(id);
        if(nhanVien == null){
            return new ModelAndView("/error.404");
        }

        Iterable<KhachHang> khachHangs = khachHangService.findAllByNhanVien(nhanVien);

        ModelAndView modelAndView = new ModelAndView("/nhanvien/view");
        modelAndView.addObject("nhanvien", nhanVien);
        modelAndView.addObject("khachhangs", khachHangs);
        return modelAndView;
    }
}
