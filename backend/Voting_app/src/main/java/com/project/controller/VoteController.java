package com.project.controller;

import com.project.model.Vote;
import com.project.model.User;
import com.project.model.Candidate;
import com.project.model.Election;
import com.project.service.VoteService;
import com.project.service.UserService;
import com.project.service.CandidateService;
import com.project.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @Autowired
    private UserService userService;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private ElectionService electionService;

    // Cast a vote
    @PostMapping("/cast")
    public ResponseEntity<?> castVote(
            @RequestParam Long userId,
            @RequestParam Long candidateId,
            @RequestParam Long electionId
    ) {
        try {
            User user = userService.getUserById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            Candidate candidate = candidateService.getCandidateById(candidateId)
                    .orElseThrow(() -> new RuntimeException("Candidate not found"));
            Election election = electionService.getElectionById(electionId)
                    .orElseThrow(() -> new RuntimeException("Election not found"));

            Vote vote = voteService.castVote(user, candidate, election);
            return ResponseEntity.ok(vote);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get all votes for an election
    @GetMapping("/election/{electionId}")
    public ResponseEntity<List<Vote>> getVotesByElection(@PathVariable Long electionId) {
        Election election = electionService.getElectionById(electionId)
                .orElseThrow(() -> new RuntimeException("Election not found"));
        return ResponseEntity.ok(voteService.getVotesByElection(election));
    }
}
