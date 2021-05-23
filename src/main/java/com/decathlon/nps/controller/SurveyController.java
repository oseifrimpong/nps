package com.decathlon.nps.controller;

import com.decathlon.nps.model.Survey;
import com.decathlon.nps.service.Impl.SurveyServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("nps/api/v1/survey")
@RestController
@Api(value = "NPS", tags = "Survey")
public class SurveyController {

    @Autowired
    private SurveyServiceImpl surveyService;


    @PostMapping
    public Survey addSurvey(@RequestBody Survey survey) {
        return surveyService.saveSurvey(survey);

    }

    @GetMapping
    public List<Survey> findAllSurveys() {
        return surveyService.getAllSurveys();
    }
}
