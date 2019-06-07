package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //http://localhost:3000/users
public class UserController {

  @GetMapping
  public String GetUser() {
    return "GetUser was called";
  }

  @PostMapping
  public String CreateUser() {
    return "CreateUser was called";
  }

  @PutMapping
  public String UpdateUser() {
    return "UpdateUser was called";
  }
}
