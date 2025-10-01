package com.project.service.impl;

import com.project.model.Election;
import com.project.repository.ElectionRepository;
import com.project.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionServiceImpl implements ElectionService {

    @Autowired
    private ElectionRepository electionRepository;

    @Override
    public Election addElection(Election election) {
        return electionRepository.save(election);
    }

    @Override
    public Election updateElection(Election election) {
        return electionRepository.save(election);
    }

    @Override
    public void deleteElection(Long id) {
        electionRepository.deleteById(id);
    }

    @Override
    public Optional<Election> getElectionById(Long id) {
        return electionRepository.findById(id);
    }

    @Override
    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }
}
