package com.decathlon.nps.controller;

import com.decathlon.nps.model.Answer;
import com.decathlon.nps.service.Impl.AnswerServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/nps/api/v1/answer")
@Api(value = "NPS", tags = "Answer")
public class AnswerController {
    @Autowired
    private AnswerServiceImpl answerService;


    @GetMapping
    public List<Answer> findAllAnswers() {
        return answerService.getAnswers();
    }

    @GetMapping("/project/{id}")
    public List<Answer> listAnswersByProject(@PathVariable UUID id) {
        return answerService.getAnswersByProject(id);
    }

    @PostMapping
    public Answer addAnswer(@RequestBody Answer answer) {
        return answerService.saveAnswer(answer);
    }
}
