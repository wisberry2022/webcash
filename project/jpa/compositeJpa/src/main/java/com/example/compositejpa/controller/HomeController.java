package com.example.compositejpa.controller;

import com.example.compositejpa.domain.ExamVo;
import com.example.compositejpa.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final ExamService exService;

    @GetMapping("/")
    public String index() {
        List<ExamVo> result = exService.getData();
        System.out.println(result);
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
