package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    @RequestMapping("/requestHeader")
    public void testRequestHeader(
            @RequestHeader(value = "Accept") String accept,
            @RequestHeader(value = "User-Agent") String UserAgent,
            @RequestHeader(value = "temp") String temp
    ) {
        System.out.println("Accept" + accept);
        System.out.println("User-Agent" + UserAgent);
        System.out.println("temp" + temp);
    }

    @RequestMapping("/requestBody")
    public void testRequestBody(
            @RequestBody String temp) {
        System.out.println("temp" + temp);
    }

    @RequestMapping(value = "requestParam")
    public void testRequestParam(@RequestParam("user") String user, @RequestParam("password") String pass) {
        System.out.println("user" + user);
        System.out.println("password" + pass);
    }

    @RequestMapping(value = "/pathVariable/{id}/{name}")
    public void testPathVariable(@PathVariable("id") int id, @PathVariable("name") String name) {
        System.out.println("id" + id);
        System.out.println("name" + name);
    }
}
