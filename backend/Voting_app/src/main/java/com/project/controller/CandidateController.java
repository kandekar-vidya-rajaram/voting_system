package com.project.controller;

import com.project.model.Candidate;
import com.project.model.Election;
import com.project.service.CandidateService;
import com.project.service.ElectionService; // to get election info
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private ElectionService electionService;

    @PostMapping("/add/{electionId}")
    public ResponseEntity<Candidate> addCandidate(@PathVariable Long electionId, @Valid @RequestBody Candidate candidate) {
        Election election = electionService.getElectionById(electionId)
                .orElseThrow(() -> new RuntimeException("Election not found"));
        candidate.setElection(election);
        Candidate savedCandidate = candidateService.addCandidate(candidate);
        return ResponseEntity.ok(savedCandidate);
    }

    @PutMapping("/update")
    public ResponseEntity<Candidate> updateCandidate(@Valid @RequestBody Candidate candidate) {
        Candidate updatedCandidate = candidateService.updateCandidate(candidate);
        return ResponseEntity.ok(updatedCandidate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.ok("Candidate deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
        return candidateService.getCandidateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/election/{electionId}")
    public ResponseEntity<List<Candidate>> getCandidatesByElection(@PathVariable Long electionId) {
        Election election = electionService.getElectionById(electionId)
                .orElseThrow(() -> new RuntimeException("Election not found"));
        return ResponseEntity.ok(candidateService.getCandidatesByElection(election));
    }
}
