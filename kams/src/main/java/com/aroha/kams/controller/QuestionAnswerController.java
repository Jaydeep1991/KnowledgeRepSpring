package com.aroha.kams.controller;

import com.aroha.kams.payload.AddQuestionPayload;
import com.aroha.kams.payload.AnswerPayload;
import com.aroha.kams.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
public class QuestionAnswerController {

    @Autowired
    private QuestionAnswerService questionService;

    @PostMapping("addQuestion")
    public ResponseEntity<?> addQuestion(@RequestBody AddQuestionPayload addQuestion){
            return ResponseEntity.ok(questionService.saveQuestion(addQuestion));
    }

    @PostMapping("addAnswer")
    public ResponseEntity<?> addAnswer(@RequestBody AnswerPayload answerPayload){
        return ResponseEntity.ok(questionService.addAnswer(answerPayload));
    }

    @GetMapping("findAllQuestionAndAnswer")
    public ResponseEntity<?> getAllQuestionAndAnswer(){
        return ResponseEntity.ok(questionService.getAllQuestionAnsAnswer());
    }

    @GetMapping("showAllQuestion")
    public ResponseEntity<?> showQuestion(){
    	return ResponseEntity.ok(questionService.showQuestion());
    }

}
