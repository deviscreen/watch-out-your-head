package com.num6pj.watchout.issue.infra;

import java.util.List;

import com.num6pj.watchout.issue.domain.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {

    @Query(value = "SELECT * FROM Issue i WHERE i.category = ?1 or i.title = ?2", nativeQuery=true)
    List<Issue> findIssuesByCategoryOrTitle(String category, String title);
}
