package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/home")

public class HomeController {
    @GetMapping(value = "/method0")
    public String method0() {
        return "method0";
    }

    //Khi trên url xuất hiện đường dẫn "localhostXXX:/home/method1",localhostXXX:/home/method1/second" thì phương
    // thức method1 của của controller HomeController sẽ được gọi
    //nhiều URI chung 1 phương thức
    @GetMapping(value = {"/method1", "/method1/second"})
    public String method1() {
        return "method1";
    }

    //Xử lý cho request có phương thức http là post và url hoặc action method là "/home/method2
    @GetMapping(value = "/method2")
    public String method2() {
        return "method2";
    }

    //Xử lý cho request có phương thức http là post hoặc get có url hoặc
    // form action method là "/home/method3
    @RequestMapping(value = "/method3", method = RequestMethod.GET)
    public String method3() {
        return "method3";
    }

    //Xử lý cho request có phương thức http là post, header có key-value: name=CodeGymDaNang và url hoặc
    // form action method là "/home/method4
    @PostMapping(value = "/method4", headers = "name=CodeGymDaNang")
    public String method4() {
        return "method4";
    }

    //Xử lý cho request có phương thức http là post, header có 2 cặp key-value: name=CodeGymDaNang, "id=100" và url
    // hoặc form action method là "/home/method5
    @RequestMapping(value = "/method5", headers = {"name=CodeGymDaNang", "id=100"}, method = RequestMethod.POST)
    public String method5() {
        return "method5";
    }


    //Controller này chỉ chỉ chấp nhận các request có content-type là application/json
    @RequestMapping(value = "/method6", consumes = {"application/json"}, method = RequestMethod.POST)
    public String method6() {
        return "method6";
    }

    //Xử lý cho request có thêm biến id
    @RequestMapping(value = "/method7/{id}")
    public ModelAndView method7(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("method7", "id", id);
        return modelAndView;
    }

    //Xử lý cho request có thêm biến id và name
    @RequestMapping(value = "/method8/{id}/{name}")
    @ResponseBody
    public ModelAndView method8(@PathVariable("id") int id, @PathVariable("name") String name) {
        Object[] a = new Object[2];
        a[0] = id;
        a[1] = name;
        ModelAndView modelAndView = new ModelAndView("method8", "model", a);
        return modelAndView;
    }
}