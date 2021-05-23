package com.decathlon.nps.service;

import com.decathlon.nps.model.Survey;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ISurveyService {
    Survey saveSurvey(Survey survey);
    List<Survey> getAllSurveys();
    ResponseEntity<Survey> getSurveyById(UUID projectId);
    Boolean isSurveyExist(String project);
}
