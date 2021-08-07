package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//어노테이션: 컴포넌트임을 알려줌
@Controller
@Slf4j
public class HelloController {

    @GetMapping("hello-mvc")
    public String helloTemplate(String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @PostConstruct
    public void postConstruct() {
        log.info("I am already CONSTRUCTED");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("이번엔?");
        log.info("I will be destroyed.");
    }

}

