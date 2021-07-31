package com.example.demo.controller;

import com.example.demo.service.MemberService;
import entity.Hello;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloRestController {

//    //field injection
//    @Autowired
//    MemberService memberService;

//    @Autowired
//    private void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    //권장방법
    final MemberService memberService; //final 선언하면 해당 변수 설정은 생성자에서만 가능

//    @Autowired
//    public HelloRestController(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @GetMapping("/hello-string")
    public String helloString(String name){
        //MemberService memberservice = new ...
        return memberService.greet(name);
    }

    @GetMapping("/hello-map")
    public Map<String, Object> helloMap(String name){
        // Map<key 타입,value 타입>
        Map<String, Object> m = new HashMap<>();
        m.put("name", name);
        return m;
    }

    @GetMapping("/hello-object")
    public Hello helloObject(String name) {
        Hello h = new Hello(name);
        return h;
    }

}
