package com.behavox.issuetracker.dao;

import com.behavox.issuetracker.entity.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueDao extends JpaRepository<IssueEntity, Integer> {
}
