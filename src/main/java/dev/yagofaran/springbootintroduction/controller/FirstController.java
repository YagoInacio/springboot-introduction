package dev.yagofaran.springbootintroduction.controller;

import org.springframework.http.ResponseEntity;
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

    @PostMapping("methodWithBodyParams")
    public String methodWithBodyParams(@RequestBody User user) {
        return "Body params: " + user.username();
    }

    @PostMapping("methodWithHeaders")
    public String methodWithHeaders(@RequestHeader("name") String name) {
        return "Header name param: " + name;
    }

    @PostMapping("methodWithHeaderList")
    public String methodWithHeaderList(@RequestHeader Map<String, String> headers) {
        return "Header list params: " + headers.entrySet();
    }

    @GetMapping("methodResponseEntity/{id}")
    public ResponseEntity<Object> methodResponseEntity(@PathVariable long id) {
        var user = new User("Yago Faran");

        if(id > 5) {
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.badRequest().body("id is lower than 5");
    }

    record User(String username){}

}
