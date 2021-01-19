package com.demo.controller;

import com.demo.pojo.DemoForm;
import com.demo.repo.DemoH2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemoController {

    @Autowired
    DemoH2Repository demoH2Repository;

    @GetMapping({"/", "/index"})
    public String index(){
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("demoForm", new DemoForm());
        model.addAttribute("demoList", demoH2Repository.findAll());
        model.addAttribute("message", "list");
        return "list";
    }
}
