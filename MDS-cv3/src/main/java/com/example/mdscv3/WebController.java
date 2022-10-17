package com.example.mdscv3;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping("staticpage")
    public String staticPage() {
        return "staticpage";
    }

    @GetMapping("dynamicpage")
    public String dynamicPage(Model model){
        model.addAttribute("name", "Harold");
        return "dynamicpage";
    }


    // HW


    @GetMapping("myself")
    public String mySelf() {
        return "myself";
    }

    @GetMapping("alice")
    public String alice(Model model){
        model.addAttribute("name", "Alice");
        return "template";
    }

    @GetMapping("bob")
    public String bob(Model model){
        model.addAttribute("name", "Bob");
        return "template";
    }
}
