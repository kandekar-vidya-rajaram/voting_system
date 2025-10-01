package com.project.service.impl;

import com.project.model.Vote;
import com.project.model.User;
import com.project.model.Candidate;
import com.project.model.Election;
import com.project.repository.VoteRepository;
import com.project.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Vote castVote(User user, Candidate candidate, Election election) throws Exception {
        // Check if user already voted in this election
        Optional<Vote> existingVote = voteRepository.findByUserAndElection(user, election);
        if (existingVote.isPresent()) {
            throw new Exception("User has already voted in this election");
        }

        // Increment candidate vote count
        candidate.setVoteCount(candidate.getVoteCount() + 1);

        // Save vote
        Vote vote = new Vote();
        vote.setUser(user);
        vote.setCandidate(candidate);
        vote.setElection(election);

        return voteRepository.save(vote);
    }

    @Override
    public Optional<Vote> getVoteByUserAndElection(User user, Election election) {
        return voteRepository.findByUserAndElection(user, election);
    }

    @Override
    public List<Vote> getVotesByElection(Election election) {
        return voteRepository.findByElection(election);
    }
}
