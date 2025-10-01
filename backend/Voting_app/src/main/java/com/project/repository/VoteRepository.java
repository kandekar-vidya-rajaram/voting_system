package com.project.repository;

import com.project.model.Election;
import com.project.model.User;
import com.project.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByUserAndElection(User user, Election election);

    List<Vote> findByElection(Election election);
}
