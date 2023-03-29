package com.boot.compositejpa02.controller;

import com.boot.compositejpa02.domain.ExamEntity;
import com.boot.compositejpa02.domain.ExamVo;
import com.boot.compositejpa02.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final ExamService exService;

    @GetMapping("/")
    public String index(Model model) {
        List<ExamVo> result = exService.getData();
        model.addAttribute("list", result);
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
