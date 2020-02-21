package codegym2019.demogiohangdongian.controller;

import codegym2019.demogiohangdongian.model.ShoppingCart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CartPageController {
    @GetMapping("/cart")
    public String cart(@ModelAttribute("shoppingCart") ShoppingCart cart, final Model model){
        model.addAttribute("cart", cart);
        return "cart";
    }
}
