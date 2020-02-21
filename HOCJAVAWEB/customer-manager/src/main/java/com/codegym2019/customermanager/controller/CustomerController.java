package com.codegym2019.customermanager.controller;


import com.codegym2019.customermanager.model.Customer;
import com.codegym2019.customermanager.services.CustomerService;
import com.codegym2019.customermanager.services.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "views/index";
    }

    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "views/create";
    }

    @PostMapping("/customer/save")
    public String save(Customer customer, RedirectAttributes redirect) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", this.customerService.findById(id));
        return "views/edit";
    }

    @PostMapping("/customer/update")
    public String update(Customer customer, RedirectAttributes redirect) {
        this.customerService.update(customer.getId(), customer);
        redirect.addFlashAttribute("success", "Modify customer successfully");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", this.customerService.findById(id));
        return "views/delete";
    }

    @PostMapping("/customer/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        this.customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed Customer successfully");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", this.customerService.findById(id));
        return "views/view";
    }
}
