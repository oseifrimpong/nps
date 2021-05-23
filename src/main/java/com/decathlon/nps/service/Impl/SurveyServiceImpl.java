package com.decathlon.nps.service.Impl;

import com.decathlon.nps.common.Constants;
import com.decathlon.nps.errors.ResourceNotFound;
import com.decathlon.nps.model.Survey;
import com.decathlon.nps.repository.SurveyRepository;
import com.decathlon.nps.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SurveyServiceImpl implements ISurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    /**
     *
     * @param survey Takes a survey model and save it but first checks
     *               if it's exists before saving
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Survey saveSurvey(Survey survey) {
        if (survey.getNpsScore() != 0) {
            throw new RuntimeException(Constants.SCORE_ERROR);
        } else if (isSurveyExist(survey.getProject())) {
            throw new RuntimeException(Constants.SURVEY_EXISTS);
        }
        return surveyRepository.save(survey);
    }

    /**
     *
     * @return Returns a list of all surveys
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<Survey> getSurveyById(UUID projectId) {
        Survey survey = surveyRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFound(Constants.SURVEY_DOES_NOT_EXISTS + projectId));
        return ResponseEntity.ok(survey);
    }

    /**
     * Checks if the survey of a project exists or not.
     * @param project project name
     * @return true/false
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean isSurveyExist(String project) {
        return surveyRepository.existsByProject(project);
    }
}
