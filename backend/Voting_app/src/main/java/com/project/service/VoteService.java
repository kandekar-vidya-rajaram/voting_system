package com.project.service;

import com.project.model.Vote;
import com.project.model.User;
import com.project.model.Candidate;
import com.project.model.Election;

import java.util.List;
import java.util.Optional;

public interface VoteService {

    Vote castVote(User user, Candidate candidate, Election election) throws Exception;

    Optional<Vote> getVoteByUserAndElection(User user, Election election);

    List<Vote> getVotesByElection(Election election);
}
