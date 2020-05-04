package com.behavox.issuetracker.util;

import com.behavox.issuetracker.entity.IssueEntity;
import com.behavox.issuetracker.entity.request.IssueRequests;
import com.behavox.issuetracker.enums.*;

import java.util.Calendar;

public class IssueMapper {


    public static IssueEntity mapCreateIssueRequestToIssueEntity(IssueRequests.CreateIssueRequest createIssueRequest){
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setIssueType(createIssueRequest.getIssueType());
        issueEntity.setPriority(createIssueRequest.getIssuePriority());
        issueEntity.setStatus(BugStatus.OPEN);
        issueEntity.setCreationDate(Calendar.getInstance().getTime());
        issueEntity.setDescription(createIssueRequest.getDescription());
        issueEntity.setAssignedUser(createIssueRequest.getUser());
        issueEntity.setTitle(createIssueRequest.getTitle());
        issueEntity.setId(createIssueRequest.getId());
        return issueEntity;
    }

    public static IssueEntity mapUpdateIssueRequestToIssueEntity(IssueRequests.UpdateIssueRequest updateIssueRequest, IssueEntity issueEntity){

        issueEntity.setPriority(updateIssueRequest.getIssuePriority()!= null ?
                updateIssueRequest.getIssuePriority() : issueEntity.getPriority());
        issueEntity.setStatus(updateIssueRequest.getStatus() != null ?
                updateIssueRequest.getStatus() : issueEntity.getStatus());
        issueEntity.setUpdatedAt(Calendar.getInstance().getTime());
        issueEntity.setDescription(updateIssueRequest.getDescription() != null ?
                updateIssueRequest.getDescription() : issueEntity.getDescription());
        issueEntity.setAssignedUser(updateIssueRequest.getUser() != null ?
                updateIssueRequest.getUser() : issueEntity.getAssignedUser());
        return issueEntity;
    }
}
