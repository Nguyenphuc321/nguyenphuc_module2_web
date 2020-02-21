package codegym209.case_study_furama_2019.controller;

import codegym209.case_study_furama_2019.model.Accomdation;
import codegym209.case_study_furama_2019.service.AccomdationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class HomeController {
    @Autowired
    private AccomdationService accomdationService;
    @GetMapping("/")
    public ModelAndView home(@RequestParam("search") Optional<Float> search, @PageableDefault(size = 5) Pageable pageable ){

        Page<Accomdation> accomdation;
        ModelAndView modelAndView = new ModelAndView("home");
        if (search.isPresent()) {
            Iterable<Accomdation> accomdations = this.accomdationService.findAllBychiphithueContaining((Float)search.get(), pageable);
            modelAndView.addObject("accomdations", accomdations);
        } else {
            Iterable<Accomdation> accomdations = this.accomdationService.findAll(pageable);
            modelAndView.addObject("accomdations", accomdations);
        }
        return modelAndView;
    }
    @GetMapping("/details/{id}")
    public ModelAndView detailAccomdation(@PathVariable Long id){
        Accomdation accomdation = accomdationService.findById(id);
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("accomdation", accomdation);
        return modelAndView;
    }
}
