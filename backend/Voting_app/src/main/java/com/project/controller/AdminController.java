package com.project.controller;

import com.project.model.Candidate;
import com.project.model.Election;
import com.project.model.User;
import com.project.service.CandidateService;
import com.project.service.ElectionService;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ElectionService electionService;

    @Autowired
    private CandidateService candidateService;

    // Get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Delete a user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    // Get all elections
    @GetMapping("/elections")
    public ResponseEntity<List<Election>> getAllElections() {
        return ResponseEntity.ok(electionService.getAllElections());
    }

    // Delete an election
    @DeleteMapping("/elections/{id}")
    public ResponseEntity<String> deleteElection(@PathVariable Long id) {
        electionService.deleteElection(id);
        return ResponseEntity.ok("Election deleted successfully");
    }

    // Get all candidates
    @GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    // Delete a candidate
    @DeleteMapping("/candidates/{id}")
    public ResponseEntity<String> deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.ok("Candidate deleted successfully");
    }
}
