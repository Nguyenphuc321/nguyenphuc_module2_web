package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class DictionaryController {
    @RequestMapping("/dictionarycontroller")
    public String loadIndex() {
        return "index";
    }

    @RequestMapping(value = "result", method = RequestMethod.GET)
    public String dictionarycontroller(
            @RequestParam("key") String key,
            Model model
    ) {
        Map<String, String> maps = new HashMap<>();
        maps.put("I", "tôi");
        maps.put("name", "tên");
        maps.put("love", "yêu");
        maps.put("live", "sống");
        if (maps.containsKey(key)) {
            model.addAttribute("result", maps.get(key));
        } else {
            model.addAttribute("message", "Not found");
        }
        return "views";
    }
}
