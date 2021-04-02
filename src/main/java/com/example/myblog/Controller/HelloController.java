package com.example.myblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "helloworld";
    }
    @GetMapping("/greetings")
    public String greetings(){
        return "greetings";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
