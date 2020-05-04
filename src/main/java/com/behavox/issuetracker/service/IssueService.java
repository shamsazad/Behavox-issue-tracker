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
	
	@Autowired
	private IssueDao issueDao;

	private static Map<BugStatusEnum, Set<BugStatusEnum>> BUG_STATE_TRANSITIONS = configureStorefrontPublicationStateTransitions();
	
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

	private static Map<BugStatusEnum, Set<BugStatusEnum>> configureStorefrontPublicationStateTransitions() {
		Map<BugStatusEnum, Set<BugStatusEnum>> map = new HashMap<>();

		StateChanges.addAsValid(map, BugStatusEnum.OPEN, BugStatusEnum.RESOLVED, BugStatusEnum.IN_PROGRESS, BugStatusEnum.CLOSED);
		StateChanges.addAsValid(map, BugStatusEnum.IN_PROGRESS, BugStatusEnum.CLOSED, BugStatusEnum.RESOLVED);
		StateChanges.addAsValid(map, BugStatusEnum.RESOLVED, BugStatusEnum.CLOSED, BugStatusEnum.RE_OPEN);
		StateChanges.addAsValid(map, BugStatusEnum.CLOSED, BugStatusEnum.RE_OPEN);
		StateChanges.addAsValid(map, BugStatusEnum.RE_OPEN, BugStatusEnum.IN_PROGRESS, BugStatusEnum.CLOSED, BugStatusEnum.RESOLVED);
		return map;
	}
}
