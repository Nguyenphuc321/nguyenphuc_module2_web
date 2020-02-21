package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping("testmodel")
    public String testmodel(Model model) {
        model.addAttribute("hello", "xin chao cac ban");
        model.addAttribute("sorry", "xin loi");
        return "test";
    }

    @RequestMapping("testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("hello", "xin chao cac ban");
        modelMap.put("sorry", "xin loi cac ban");
        return "test";
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(ModelAndView modelAndView) {
//        modelAndView  = new ModelAndView("test");
//        modelAndView.addObject("hello","minh la add");
//        return modelAndView;
        return new ModelAndView("test", "hello", "minh la nguyen van A");
    }
}
