package com.example.helloworld.userservice.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.example.helloworld.modelrequest.UserRequest;
import com.example.helloworld.modelresponse.UserRest;
import com.example.helloworld.userservice.userinterface.UserService;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
  Map<String, UserRest> users;
  
  @Override
  public UserRest createUser(UserRequest userDetails) {
    UserRest returnValue = new UserRest();
    returnValue.setLastname(userDetails.getLastname());
    returnValue.setFirstname(userDetails.getFirstname());
    returnValue.setEmail(userDetails.getEmail());
    
    String userID = UUID.randomUUID().toString();
    returnValue.setUserId(userID);
    if (users == null) users = new HashMap<>();
    users.put(userID, returnValue);
    return returnValue;
  }
  
}