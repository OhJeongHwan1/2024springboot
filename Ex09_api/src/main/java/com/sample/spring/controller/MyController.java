package com.sample.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping("/hello")
    public String hello() {
        return "get-hello";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "post-hello";
    }

    @PutMapping("/hello")
    public String putHello() {
        return "put-hello";
    }

    @DeleteMapping("/hello")
    public String deleteHello() {
        return "delete-hello";
    }

    @GetMapping("/test/param") //param?name=&age=
    public String requestParam(@RequestParam String name, @RequestParam String age) {
        return "hello, request param, i am " + name + " , " + age;
    }

    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVariable(@PathVariable String name, @PathVariable String age) {
        return "hello, request Path, i am " + name + " , " + age;
    }

    @PostMapping("test")
    public String requestBody(@RequestBody RequestDto request){
        return "hello, request body, i am " + request.getName() + " , " + request.getAge();
    }
}
