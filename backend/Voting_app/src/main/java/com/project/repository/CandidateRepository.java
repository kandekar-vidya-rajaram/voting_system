package com.project.repository;

import com.project.model.Candidate;
import com.project.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByElection(Election election);
}
