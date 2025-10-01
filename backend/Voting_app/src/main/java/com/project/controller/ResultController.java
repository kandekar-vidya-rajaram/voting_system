package com.project.controller;

import com.project.model.Candidate;
import com.project.model.Election;
import com.project.model.Vote;
import com.project.service.CandidateService;
import com.project.service.ElectionService;
import com.project.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ElectionService electionService;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private VoteService voteService;

    // Get result of a specific election
    @GetMapping("/election/{electionId}")
    public ResponseEntity<?> getElectionResult(@PathVariable Long electionId) {
        Election election = electionService.getElectionById(electionId)
                .orElseThrow(() -> new RuntimeException("Election not found"));

        List<Candidate> candidates = candidateService.getCandidatesByElection(election);
        Map<String, Integer> result = new HashMap<>();

        for (Candidate candidate : candidates) {
            result.put(candidate.getName() + " (" + candidate.getParty() + ")", candidate.getVoteCount());
        }

        // Find winner(s)
        int maxVotes = candidates.stream().mapToInt(Candidate::getVoteCount).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.getVoteCount() == maxVotes) {
                winners.add(candidate.getName());
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("electionTitle", election.getTitle());
        response.put("results", result);
        response.put("winner", winners);

        return ResponseEntity.ok(response);
    }
}
