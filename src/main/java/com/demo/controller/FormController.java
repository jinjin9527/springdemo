package com.demo.controller;

import com.demo.pojo.DemoEntiry;
import com.demo.pojo.DemoForm;
import com.demo.repo.DemoH2Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {

    @Value("${from.value}")
    private String dataSource;

    @Autowired
    DemoH2Repository demoH2Repository;

    @GetMapping
    public String init(Model model) {
        model.addAttribute("demoForm", new DemoForm());
        model.addAttribute("demoList", demoH2Repository.findAll());
        return "form";
    }

    @PostMapping
    public String submit(DemoForm form, Model model) {
        DemoEntiry demo = new DemoEntiry();
        BeanUtils.copyProperties(form, demo);
        demo.setFromDataSource(dataSource);
        demoH2Repository.save(demo);

        model.addAttribute("demoList", demoH2Repository.findAll());
        model.addAttribute("message", "save");
        return "list";
    }
}
