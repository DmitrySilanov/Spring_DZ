package ru.gb.homework4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class RandomController {
    @GetMapping("/random")
    public String getRandom(Model model) {
        Random rnd = new Random();
        int num = rnd.nextInt(100);
        model.addAttribute("number", num);
        return "random";
    }
}
