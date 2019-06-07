package com.example.helloworld.modelrequest;

import javax.validation.constraints.NotNull;

public class UserUpdateRequest{
  @NotNull(message = "Last Name is required")
  private String lastname;

  @NotNull(message = "First Name is required")
  private String firstname;

  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
}