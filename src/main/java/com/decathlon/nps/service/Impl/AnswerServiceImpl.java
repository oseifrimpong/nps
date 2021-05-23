package com.decathlon.nps.service.Impl;

import com.decathlon.nps.common.Constants;
import com.decathlon.nps.model.Answer;
import com.decathlon.nps.model.Survey;
import com.decathlon.nps.repository.AnswerRepository;
import com.decathlon.nps.repository.SurveyRepository;
import com.decathlon.nps.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Answer saveAnswer(Answer answer) {
        Survey survey = answer.getSurvey();
        if (survey == null || survey.getId() == null) {
            throw new RuntimeException(Constants.SURVEY_DOES_NOT_EXISTS);
        } else if (answer.getScore() < 0 || answer.getScore() > 10) {
            throw new RuntimeException(Constants.SCORE_ERROR);
        }

      survey = surveyRepository.getOne(survey.getId());

        List<Answer> answers = answerRepository.findAllBySurveyId(survey.getId());
        answers.add(answer);
        int answerCount = answers.size();
        if (answerCount != 0) {
            var promoterCount = 0;
            var detractorCount = 0;
            for (Answer anAnswer : answers) {
                if (anAnswer.getScore() >= 9) {
                    promoterCount++;
                } else if (anAnswer.getScore() <= 6) {
                    detractorCount++;
                }
            }
            var npsScore = (int) (100 * ((float) (promoterCount - detractorCount) / answerCount));
            survey.setNpsScore(npsScore);
            surveyRepository.save(survey);
        }
        return answerRepository.save(answer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Answer> getAnswersByProject(UUID projectId) {
        return answerRepository.findAllBySurveyId(projectId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }
}
