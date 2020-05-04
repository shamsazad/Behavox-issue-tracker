package com.behavox.issuetracker.util;

import com.behavox.issuetracker.entity.User;
import com.behavox.issuetracker.entity.request.UserRequests;

public class UserMapper {

    public static User mapCreateUserRequestToUser(UserRequests.CreateUserRequest createUserRequest) {

        User user = new User();
        user.setName(createUserRequest.getName());
        user.setProfile(createUserRequest.getProfile());
        return user;
    }

    public static User mapUpdateUserRequestToUser(UserRequests.UpdateUserRequest updateUserRequest, User user) {

        user.setProfile(updateUserRequest.getProfile() != null ?
                updateUserRequest.getProfile() : user.getProfile());

        return user;
    }
}
