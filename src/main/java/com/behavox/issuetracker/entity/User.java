package com.behavox.issuetracker.entity;

import com.behavox.issuetracker.entity.base.BaseEntity;
import com.behavox.issuetracker.enums.UserProfile;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends BaseEntity {

  @NotNull
  private String name;
  @NotNull
  private UserProfile profile;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserProfile getProfile() {
    return profile;
  }

  public void setProfile(UserProfile profileEnum) {
    this.profile = profileEnum;
  }
}
