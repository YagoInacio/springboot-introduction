package dev.yagofaran.springbootintroduction.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/firstController")
public class FirstController {

    @GetMapping("/firstMethod/{id}")
    public String firstMethod(@PathVariable String id) {
        return "Param on path is " + id;
    }

    @GetMapping("/methodWithQueryParams")
    public String methodWithQueryParams(@RequestParam String id) {
        return "Param on query is " + id;
    }

    @GetMapping("/methodWithQueryParams2")
    public String methodWithQueryParams2(@RequestParam Map<String, String> allParams) {
        return "Params mapped on query are " + allParams.entrySet();
    }

}
