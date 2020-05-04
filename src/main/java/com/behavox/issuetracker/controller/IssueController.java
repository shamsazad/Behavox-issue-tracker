package com.behavox.issuetracker.controller;

import com.behavox.issuetracker.entity.IssueEntity;
import com.behavox.issuetracker.entity.request.IssueRequests;
import com.behavox.issuetracker.service.IssueService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/issue")
public class IssueController {
	
	private IssueService issueService;

	public IssueController(IssueService issueService) {
		this.issueService = issueService;
	}
	
	@GetMapping(value = "/issues")
	@ResponseStatus(value = HttpStatus.OK)
	public List<IssueEntity> getIssues() {
		return issueService.getBugs();
	}
	
	@PostMapping(value = "/create-issue")
	@ResponseStatus(value = HttpStatus.CREATED)
    public IssueEntity create(@RequestBody @NotNull IssueRequests.CreateIssueRequest issueEntity) {
        return issueService.add(issueEntity);
    }
	
	@PutMapping(value = "/update-issue/{id}")
	@ResponseStatus(value = HttpStatus.OK)
    public IssueEntity update(@RequestBody @NotNull IssueRequests.UpdateIssueRequest updateIssueRequest) {
		return issueService.update(updateIssueRequest);
    }

	@DeleteMapping(value = "/delete-issue/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Integer bugId) {
		issueService.delete(bugId);
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public IssueEntity getBug(@PathVariable(value = "id") Integer bugId) {
		return issueService.getIssue(bugId);
	}
	
}
