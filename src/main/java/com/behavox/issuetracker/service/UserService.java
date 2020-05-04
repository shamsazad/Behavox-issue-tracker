package com.behavox.issuetracker.service;

import com.behavox.issuetracker.dao.UserDao;
import com.behavox.issuetracker.entity.User;
import com.behavox.issuetracker.entity.request.UserRequests;
import com.behavox.issuetracker.util.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private UserDao userDao;

  public UserService(UserDao userDao) {
    this.userDao = userDao;
  }

  public User add(UserRequests.CreateUserRequest createUserRequest) {
    User user = UserMapper.mapCreateUserRequestToUser(createUserRequest);
    return userDao.save(user);
  }

  public List<User> getDevelopers(){
    return userDao.findAll();
  }

  public User getById(Integer id) {
    return userDao.getOne(id);
  }

  public User update(UserRequests.UpdateUserRequest updateUserRequest) {
    User user = getById(updateUserRequest.getId());
    User updateUser = UserMapper.mapUpdateUserRequestToUser(updateUserRequest, user);
    return userDao.save(updateUser);
  }

  public void delete(Integer developerId) {
    User user = getById(developerId);
    userDao.delete(user);
  }
}
