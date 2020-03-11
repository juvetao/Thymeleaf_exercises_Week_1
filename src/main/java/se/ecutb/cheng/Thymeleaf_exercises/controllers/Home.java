package se.ecutb.cheng.Thymeleaf_exercises.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    @GetMapping("/index")
    public String index(Model model){

//        model.addAttribute("in");
        return "index";
    }

    private List<String> contacts = new ArrayList<>();

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("contacts", contacts);
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam String contact){
        if(!contact.isEmpty()){
            contacts.add(contact);
        }
        return "redirect:/contact";
    }


    public void contactList(Model model, List<String> contacts){
        model.addAttribute("contacts", contacts);
    }

    @GetMapping("/about")
    public void about(Model model){

    }

}
