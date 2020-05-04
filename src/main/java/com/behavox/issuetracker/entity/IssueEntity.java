package com.behavox.issuetracker.entity;

import com.behavox.issuetracker.entity.base.IssuesBase;
import com.behavox.issuetracker.enums.*;

import javax.persistence.Entity;
import java.util.Date;


@Entity
public class IssueEntity extends IssuesBase {
	
	private IssueType issueType;
	
	private BugStatus status;
	
	private IssuePriority priority;

	private Date updatedAt;
	
	public BugStatus getStatus() {
		return status;
	}

	public void setStatus(BugStatus status) {
		this.status = status;
	}

	public IssuePriority getPriority() {
		return priority;
	}

	public void setPriority(IssuePriority priority) {
		this.priority = priority;
	}

	public IssueType getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
