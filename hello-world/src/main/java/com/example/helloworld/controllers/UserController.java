package com.example.helloworld.controllers;

import com.example.helloworld.modelresponse.UserRest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

  // need to add dependency in pom.xml if want XML response
  @GetMapping(path="/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })//MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
    UserRest returnValue = new UserRest();
    returnValue.setLastname("Doe");
    returnValue.setFirstname("Jane");
    returnValue.setEmail("Jane.Doe@gmail.com");
    return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
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
