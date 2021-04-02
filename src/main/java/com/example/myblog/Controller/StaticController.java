package com.example.myblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaticController {
    @GetMapping("/articles/Privacy")
    public String privacy(Model model){
        model.addAttribute("privacy","welcome to page of privacy");
        return "articles/Privacy";
    }

    @GetMapping("/articles/Terms")
    public String terms(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "articles/Terms";
    }
}
