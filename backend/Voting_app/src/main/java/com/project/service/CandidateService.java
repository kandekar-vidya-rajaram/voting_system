package com.project.service;

import com.project.model.Candidate;
import com.project.model.Election;

import java.util.List;
import java.util.Optional;

public interface CandidateService {

    Candidate addCandidate(Candidate candidate);

    Candidate updateCandidate(Candidate candidate);

    void deleteCandidate(Long id);

    Optional<Candidate> getCandidateById(Long id);

    List<Candidate> getAllCandidates();

    List<Candidate> getCandidatesByElection(Election election);
}
