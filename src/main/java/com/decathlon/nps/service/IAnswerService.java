package com.decathlon.nps.service;

import com.decathlon.nps.model.Answer;

import java.util.List;
import java.util.UUID;

public interface IAnswerService {

    Answer saveAnswer(Answer answer);
    List<Answer> getAnswersByProject(UUID projectId);
    List<Answer> getAnswers();
}
