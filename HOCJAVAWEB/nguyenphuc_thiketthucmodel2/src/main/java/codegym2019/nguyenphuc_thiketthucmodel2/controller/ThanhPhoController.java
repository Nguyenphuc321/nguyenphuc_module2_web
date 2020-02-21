package codegym2019.nguyenphuc_thiketthucmodel2.controller;

import codegym2019.nguyenphuc_thiketthucmodel2.model.ThanhPho;
import codegym2019.nguyenphuc_thiketthucmodel2.service.ThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ThanhPhoController {
    @Autowired
    private ThanhPhoService thanhPhoService;

    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<ThanhPho> thanhPhoList = thanhPhoService.findAll();
        modelAndView.addObject("listThanhPho",thanhPhoList);
        return modelAndView;
    }

    @GetMapping("/find-tp")
    public ModelAndView findKh(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView("index");
        List<ThanhPho> listThanhPho = thanhPhoService.findAllByName(name);
        modelAndView.addObject("listThanhPho",listThanhPho);
        return modelAndView;
    }

    @GetMapping("/edit-tp/{id}")
    public ModelAndView getEdit(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        ThanhPho thanhPho = thanhPhoService.findById(id);
        modelAndView.addObject("thanhpho",thanhPho);
        return modelAndView;
    }

    @PostMapping("/edit-tp")
    public ModelAndView saveKH(@ModelAttribute("thanhpho") ThanhPho thanhPho){
        thanhPhoService.save(thanhPho);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("message","Bạn đã cập nhật thành công");
        return modelAndView;
    }

    @GetMapping("/delete-tp/{id}")
    public ModelAndView getDelete(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        ThanhPho thanhPho = thanhPhoService.findById(id);
        modelAndView.addObject("thanhpho",thanhPho);
        return modelAndView;
    }
    @PostMapping("/delete-tp")
    public ModelAndView deleteKH(@ModelAttribute("thanhpho") ThanhPho thanhPho){
        thanhPhoService.delete(thanhPho);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("message","Bạn đã xóa thành công");
        return modelAndView;
    }

    @GetMapping("/new-tp")
    public ModelAndView getDelete(){
        ModelAndView modelAndView = new ModelAndView("new");
        modelAndView.addObject("thanhpho",new ThanhPho());
        return modelAndView;
    }

    @PostMapping("/create-tp")
    public ModelAndView createKH(@ModelAttribute("thanhpho") ThanhPho thanhPho){
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        thanhPhoService.save(thanhPho);
        modelAndView.addObject("message","Thành công");
        return modelAndView;
    }
//    @PostMapping("/create-tp")
//    public ModelAndView checkValidation(@Validated @ModelAttribute("thanhpho") ThanhPho thanhPho, BindingResult bindingResult) {
//        if (bindingResult.hasFieldErrors()) {
//            ModelAndView modelAndView = new ModelAndView("redirect:/");
//            thanhPhoService.save(thanhPho);
//            modelAndView.addObject("message","thànhcông");
//            return modelAndView;
//        }
//        ModelAndView modelAndView = new ModelAndView("result");
//        return modelAndView;
//    }

}
