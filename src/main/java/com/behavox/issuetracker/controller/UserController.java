package com.behavox.issuetracker.controller;

import com.behavox.issuetracker.entity.User;
import com.behavox.issuetracker.entity.request.UserRequests;
import com.behavox.issuetracker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK)
  public List<User> getUserList() {
    return userService.getDevelopers();
  }

  @PostMapping(value = "/create-user")
  @ResponseStatus(value = HttpStatus.CREATED)
  public User create(@RequestBody @Valid UserRequests.CreateUserRequest createUserRequest) {
    return userService.add(createUserRequest);
  }

  @PutMapping(value = "/update-user")
  @ResponseStatus(value = HttpStatus.OK)
  public User update(@RequestBody @Valid UserRequests.UpdateUserRequest updateUserRequest) {
    return userService.update(updateUserRequest);
  }

  @DeleteMapping(value = "/delete-user/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void delete(@PathVariable(value = "id") Integer developerId) {
    userService.delete(developerId);
  }
}
