package com.behavox.issuetracker.service;

import com.behavox.issuetracker.dao.IssueDao;
import com.behavox.issuetracker.entity.IssueEntity;
import com.behavox.issuetracker.entity.request.IssueRequests;
import com.behavox.issuetracker.enums.*;
import com.behavox.issuetracker.exception.InvalidStateTransitionOfBug;
import com.behavox.issuetracker.util.IssueMapper;
import com.behavox.issuetracker.util.StateChanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public class IssueService {
	
	private IssueDao issueDao;

	public IssueService(IssueDao issueDao) {
		this.issueDao = issueDao;
	}

	private static Map<BugStatus, Set<BugStatus>> BUG_STATE_TRANSITIONS = configureStorefrontPublicationStateTransitions();
	
	public List<IssueEntity> getBugs(){
		return issueDao.findAll();
	}
	
	public IssueEntity getById(Integer id) {
		return issueDao.getOne(id);
	}

	public IssueEntity add(IssueRequests.CreateIssueRequest bug) {
		IssueEntity issueEntity = IssueMapper.mapCreateIssueRequestToIssueEntity(bug);
		return issueDao.save(issueEntity);
	}

	public IssueEntity update(IssueRequests.UpdateIssueRequest bug) {
		IssueEntity issueEntity = getById(bug.getId());

		if(!StateChanges.transitionIsValid(BUG_STATE_TRANSITIONS, issueEntity.getStatus(), bug.getStatus())){
			throw new InvalidStateTransitionOfBug("invalid transition");
		}
		return issueDao.save(IssueMapper.mapUpdateIssueRequestToIssueEntity(bug, issueEntity));
	}

	public void delete(Integer issueId) {
		IssueEntity issueEntity = getById(issueId);
		issueDao.delete(issueEntity);
	}

	public IssueEntity getIssue(Integer bugId) {
		return issueDao.getOne(bugId);
	}

	private static Map<BugStatus, Set<BugStatus>> configureStorefrontPublicationStateTransitions() {
		Map<BugStatus, Set<BugStatus>> map = new HashMap<>();

		StateChanges.addAsValid(map, BugStatus.OPEN, BugStatus.RESOLVED, BugStatus.IN_PROGRESS, BugStatus.CLOSED);
		StateChanges.addAsValid(map, BugStatus.IN_PROGRESS, BugStatus.CLOSED, BugStatus.RESOLVED, BugStatus.OPEN);
		StateChanges.addAsValid(map, BugStatus.RESOLVED, BugStatus.CLOSED, BugStatus.RE_OPEN);
		StateChanges.addAsValid(map, BugStatus.CLOSED, BugStatus.RE_OPEN);
		StateChanges.addAsValid(map, BugStatus.RE_OPEN, BugStatus.IN_PROGRESS, BugStatus.CLOSED, BugStatus.RESOLVED);
		return map;
	}
}
