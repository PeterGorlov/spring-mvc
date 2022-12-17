package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "surname", required = false) String surname,
                        Model model) {

        model.addAttribute("message", "Hello :" + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodBye() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {

        switch (action) {
            case  ("addition"):
                model.addAttribute("message", a + b);;
                break;
            case ("subtraction"):
                model.addAttribute("message", a - b);;
                break;
            case ("multiplication"):
                model.addAttribute("message", a * b);;
                break;
            case ("division"):
                model.addAttribute("message", a / b);;
                break;
            default:
                model.addAttribute("message", "Please enter a valid delimiter ");;
                break;
        }

        return "first/calculator";
    }
}
