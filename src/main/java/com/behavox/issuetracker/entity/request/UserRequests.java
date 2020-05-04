package com.behavox.issuetracker.entity.request;

import com.behavox.issuetracker.entity.base.BaseEntity;
import com.behavox.issuetracker.enums.UserProfile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.NotNull;

public class UserRequests {

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreateUserRequest extends BaseEntity {

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

        public void setProfile(UserProfile profile) {
            this.profile = profile;
        }
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UpdateUserRequest {

        @NotNull
        private Integer id;

        @NotNull
        private UserProfile profile;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public UserProfile getProfile() {
            return profile;
        }

        public void setProfile(UserProfile profile) {
            this.profile = profile;
        }
    }

}
