package ua.com.owu.spring_boot_third_try.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home (){
        return "index";
    }

    @PostMapping("/saveUser")
    public String saveUser (){
        return "userSaveDone";
    }
}
