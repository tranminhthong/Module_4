package com.codegym.controller;

import com.codegym.entities.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CityController {
    @GetMapping("/list-city")
    public String list(){
        return "list";
    }

    @GetMapping("/view-city")
    public String viewOneCity(@ModelAttribute City city){
        return "view";
    }
}
