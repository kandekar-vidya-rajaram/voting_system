package com.project.service;

import com.project.model.Election;

import java.util.List;
import java.util.Optional;

public interface ElectionService {

    Election addElection(Election election);

    Election updateElection(Election election);

    void deleteElection(Long id);

    Optional<Election> getElectionById(Long id);

    List<Election> getAllElections();
}
