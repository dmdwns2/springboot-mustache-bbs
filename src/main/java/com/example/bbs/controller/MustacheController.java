package com.example.bbs.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class MustacheController {

    @GetMapping(value = "/hi")
    public String mustacheCon(Model model){
        model.addAttribute("username", "jun");
        return "greetings";
    }

    @GetMapping(value = "/hi/{id}")
    public String mustacheCon2(@PathVariable String id, Model model){
        model.addAttribute("username", "jun");
        model.addAttribute("id",id);
        return "greetings";
    }
}
