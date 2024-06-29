package com.example.cms.diagnosis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    @Autowired
    public DiagnosisService(DiagnosisRepository diagnosisRepository)
    {
        this.diagnosisRepository = diagnosisRepository;
    }

    public List<Diagnosis> getAllDiagnoses()
    {


        return diagnosisRepository.findAll();
    }
}
