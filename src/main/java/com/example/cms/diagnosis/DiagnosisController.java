package com.example.cms.diagnosis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/diagnosis")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService)
    {
        this.diagnosisService=diagnosisService;
    }

    @GetMapping
    public List<Diagnosis> getAllDiagnoses()
    {
        return diagnosisService.getAllDiagnoses();
    }
}
