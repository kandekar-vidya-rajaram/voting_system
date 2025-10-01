package com.project.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Candidate name is required")
    private String name;

    @NotBlank(message = "Party name is required")
    private String party;

    @ManyToOne
    @JoinColumn(name = "election_id")
    @JsonIgnore
    private Election election; 

    private int voteCount = 0; 

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getParty() { return party; }
    public void setParty(String party) { this.party = party; }
    public Election getElection() { return election; }
    public void setElection(Election election) { this.election = election; }
    public int getVoteCount() { return voteCount; }
    public void setVoteCount(int voteCount) { this.voteCount = voteCount; }
}
