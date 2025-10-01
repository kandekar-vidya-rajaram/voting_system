package com.project.controller;

import com.project.model.Election;
import com.project.service.ElectionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elections")

@CrossOrigin(origins = "http://localhost:3000") 
public class ElectionController {

    @Autowired
    private ElectionService electionService;

    @PostMapping("/add")
    public ResponseEntity<Election> addElection(@Valid @RequestBody Election election) {
        return ResponseEntity.ok(electionService.addElection(election));
    }

    @PutMapping("/update")
    public ResponseEntity<Election> updateElection(@Valid @RequestBody Election election) {
        return ResponseEntity.ok(electionService.updateElection(election));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteElection(@PathVariable Long id) {
        electionService.deleteElection(id);
        return ResponseEntity.ok("Election deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<Election>> getAllElections() {
        return ResponseEntity.ok(electionService.getAllElections());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Election> getElectionById(@PathVariable Long id) {
        return electionService.getElectionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
