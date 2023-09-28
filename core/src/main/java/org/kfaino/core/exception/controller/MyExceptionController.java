package org.kfaino.core.exception.controller;

import jakarta.validation.Valid;
import org.kfaino.core.exception.exception.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("exception")
public class MyExceptionController {

    @GetMapping("/endpoint")
    public String endPoint() throws Exception {
        throw new Exception("统一异常捕获到的出错！");
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleMyException(Exception e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name + "!";
    }


    @PostMapping("/user")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>("User created successfully!" + user.toString(), HttpStatus.CREATED);
    }


}
