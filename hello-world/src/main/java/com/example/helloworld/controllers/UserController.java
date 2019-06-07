package com.example.helloworld.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //http://localhost:3000/users
public class UserController {

  @GetMapping()
  public String getUsers(@RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="limit", defaultValue = "30") int limit) {
    return "getUsers was called with params: page - " + page + " limit - " + limit;
  }
  //RequestParam with no defaultValue will be required info.
  //can also have required = false for String param

  @GetMapping(path="/{userId}")
  public String getUser(@PathVariable String userId) {
    return "getUser was called with Id " + userId;
  }

  @PostMapping
  public String createUser() {
    return "createUser was called";
  }

  @PutMapping
  public String updateUser() {
    return "updateUser was called";
  }

  @DeleteMapping
  public String deleteUser() {
    return "deleteUser was called";
  }
}
