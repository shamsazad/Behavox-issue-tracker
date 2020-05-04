package com.behavox.issuetracker.entity.request;

import com.behavox.issuetracker.entity.User;
import com.behavox.issuetracker.entity.base.BaseEntity;
import com.behavox.issuetracker.enums.BugStatusEnum;
import com.behavox.issuetracker.enums.IssuePriorityEnum;
import com.behavox.issuetracker.enums.IssueTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.NotNull;

public class IssueRequests {

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreateIssueRequest extends BaseEntity {

        @NotNull
        private String description;

        @NotNull
        private IssueTypeEnum issueType;

        @NotNull
        private IssuePriorityEnum issuePriorityEnum;

        @NotNull
        private String title;

        private User user;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public IssueTypeEnum getIssueType() {
            return issueType;
        }

        public void setIssueType(IssueTypeEnum issueType) {
            this.issueType = issueType;
        }

        public IssuePriorityEnum getIssuePriorityEnum() {
            return issuePriorityEnum;
        }

        public void setIssuePriorityEnum(IssuePriorityEnum issuePriorityEnum) {
            this.issuePriorityEnum = issuePriorityEnum;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UpdateIssueRequest {

        @NotNull
        private Integer Id;

        private String description;

        private Integer developerId;

        private BugStatusEnum status;

        private IssuePriorityEnum issuePriorityEnum;

        private User user;

        public Integer getId() {
            return Id;
        }

        public void setId(Integer id) {
            Id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getDeveloperId() {
            return developerId;
        }

        public void setDeveloperId(Integer developerId) {
            this.developerId = developerId;
        }

        public BugStatusEnum getStatus() {
            return status;
        }

        public void setStatus(BugStatusEnum status) {
            this.status = status;
        }

        public IssuePriorityEnum getIssuePriorityEnum() {
            return issuePriorityEnum;
        }

        public void setIssuePriorityEnum(IssuePriorityEnum issuePriorityEnum) {
            this.issuePriorityEnum = issuePriorityEnum;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

}
