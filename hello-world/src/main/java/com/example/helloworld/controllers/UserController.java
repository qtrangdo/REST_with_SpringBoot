package com.example.helloworld.controllers;

import java.util.Map;

import javax.validation.Valid;

import com.example.helloworld.modelrequest.UserRequest;
import com.example.helloworld.modelrequest.UserUpdateRequest;
import com.example.helloworld.modelresponse.UserRest;
import com.example.helloworld.modelresponse.UserServiceException;
import com.example.helloworld.userservice.userinterface.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //http://localhost:3000/users
public class UserController {

  // similar to Javascript object
  Map<String, UserRest> users;

  //inject dependency (interface ?) for testing
  @Autowired
  UserService userService;

  @GetMapping()
  public String getUsers(@RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="limit", defaultValue = "30") int limit) {
    return "getUsers was called with params: page - " + page + " limit - " + limit;
  }
  //RequestParam with no defaultValue will be required info.
  //can also have required = false for String param

  // need to add dependency in pom.xml if want XML response
  @GetMapping(path="/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })//MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
    // if (true) throw new UserServiceException("An exception is thrown");

    if (users.containsKey(userId)) {
      return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @PostMapping(
    consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE }
  )
  // @Valid is a part of Web dependency
  public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserRequest userDetails) {
    UserRest returnValue = userService.createUser(userDetails);
    
    return new ResponseEntity<UserRest>(returnValue, HttpStatus.CREATED);
  }

  @PutMapping(
    path="/{userId}",
    consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
    produces = { MediaType.APPLICATION_JSON_VALUE }
  )
  public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @Valid @RequestBody UserUpdateRequest userDetails) {
    UserRest storedUserDetails = users.get(userId);
    storedUserDetails.setLastname(userDetails.getLastname()); 
    storedUserDetails.setFirstname(userDetails.getFirstname());
    users.put(userId, storedUserDetails);
    return new ResponseEntity<UserRest>(storedUserDetails, HttpStatus.OK);
  }

  @DeleteMapping(path="/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
    users.remove(userId);
    return ResponseEntity.noContent().build();
  }
}
