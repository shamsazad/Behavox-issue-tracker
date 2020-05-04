package com.behavox.issuetracker.service;

import com.behavox.issuetracker.dao.IssueDao;
import com.behavox.issuetracker.entity.IssueEntity;
import com.behavox.issuetracker.enums.BugStatus;
import com.behavox.issuetracker.enums.IssueType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class IssueServiceTest {

    @Mock
    private IssueDao issueDao;

    private IssueService issueService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        issueService = new IssueService(issueDao);

        Mockito.when(issueService.getById(anyInt())).thenReturn(createIssue());
    }

    private IssueEntity createIssue() {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setStatus(BugStatus.OPEN);
        issueEntity.setIssueType(IssueType.BUG);
        issueEntity.setDescription("yahoo");
        return issueEntity;
    }

    @Test
    public void testGetById() {
        IssueEntity issueEntity = issueService.getById(1);
        Assert.assertEquals(issueEntity.getStatus(),BugStatus.OPEN);
        Assert.assertEquals(issueEntity.getDescription(), "yahoo" );
    }
}
