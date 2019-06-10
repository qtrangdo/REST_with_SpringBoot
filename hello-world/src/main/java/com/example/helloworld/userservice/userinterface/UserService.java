package com.example.helloworld.userservice.userinterface;

import com.example.helloworld.modelrequest.UserRequest;
import com.example.helloworld.modelresponse.UserRest;

public interface UserService {
  UserRest createUser(UserRequest userDetails);
}