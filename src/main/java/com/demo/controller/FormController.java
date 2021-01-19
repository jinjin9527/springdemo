package com.demo.controller;

import com.demo.pojo.Demo;
import com.demo.pojo.DemoForm;
import com.demo.service.DemoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {
    @Autowired
    DemoService demoService;

    @GetMapping
    public String init(Model model) {
        model.addAttribute("demoForm", new DemoForm());
        return "form";
    }

    @PostMapping
    public String submit(DemoForm form, Model model) {
        Demo demo = new Demo();
        BeanUtils.copyProperties(form, demo);
        demoService.save(demo);
        model.addAttribute("demoList", demoService.list());
        model.addAttribute("message", "save");
        return "list";
    }
}
