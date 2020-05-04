package com.behavox.issuetracker.entity;

import com.behavox.issuetracker.entity.base.IssuesBase;
import com.behavox.issuetracker.enums.*;

import javax.persistence.Entity;
import java.util.Date;


@Entity
public class IssueEntity extends IssuesBase {
	
	private IssueTypeEnum issueType;
	
	private BugStatusEnum status;
	
	private IssuePriorityEnum priority;

	private Date updatedAt;
	
	public BugStatusEnum getStatus() {
		return status;
	}

	public void setStatus(BugStatusEnum status) {
		this.status = status;
	}

	public IssuePriorityEnum getPriority() {
		return priority;
	}

	public void setPriority(IssuePriorityEnum priority) {
		this.priority = priority;
	}

	public IssueTypeEnum getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueTypeEnum issueType) {
		this.issueType = issueType;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
