package se.ecutb.cheng.Thymeleaf_exercises.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Fever {
    //private double temperature;

    @GetMapping("/temperature")
    public String temperature(@RequestParam(value ="temperature", required = false, defaultValue = "0.0") double temperature, Model model) throws ParseException {
        String message = null;
        if(temperature >= 36.3 && temperature <= 37.3){
            message = "Normal";
        }else if(temperature > 37.3 && temperature <= 40.0){
            message = "Fever";
        }else if(temperature > 40.0){
            message = "Hyperthermia";
        }
        model.addAttribute("temperature", message);
        return "temperature";
    }

}
