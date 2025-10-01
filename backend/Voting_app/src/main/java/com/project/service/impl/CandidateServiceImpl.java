package com.project.service.impl;

import com.project.model.Candidate;
import com.project.model.Election;
import com.project.repository.CandidateRepository;
import com.project.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public List<Candidate> getCandidatesByElection(Election election) {
        return candidateRepository.findByElection(election);
    }
}
