package codegym2019.casestudy_2019.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/admin")
    public String getAdminPage(){
        return "Sercurity/admin";
    }
    @GetMapping("/403")
    public String get403Page(){
        return "Sercurity/403";
    }

    @GetMapping("/review")
    public String getReviewPage(){
        return "dichvu/review";
    }
}
