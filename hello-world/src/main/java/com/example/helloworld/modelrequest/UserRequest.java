package com.example.helloworld.modelrequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-defineconstraints-spec

public class UserRequest {
  @NotNull(message="Last name cannot be null")
  private String lastname;

  @NotNull(message="First name cannot be null")
  private String firstname;

  @NotNull(message="Email cannot be null")
  @Email
  private String email;

  @NotNull(message="Password cannot be null")
  @Size(min=8, max=16, message = "Password must be from 8 to 16 characters")
  private String password;

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

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}