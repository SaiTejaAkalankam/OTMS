package com.ooad.controller;

import com.ooad.dto.Question;
import com.ooad.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/getQuestion/{questionId}", produces = "application/json")
    public ResponseEntity<Optional<Question>> getQuestion(@PathVariable Integer questionId) {
        Optional<Question> question = questionService.getQuestion(questionId);
        if (question.isPresent())
            return new ResponseEntity<Optional<Question>>(question, HttpStatus.OK);
        return new ResponseEntity<Optional<Question>>(question, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getQuestions/{testId}", produces = "application/json")
    public List<Question> getQuestions(@PathVariable Integer testId) {
        if (testId != null) {
            return questionService.findAllByTestId(testId);
        } else {
            return questionService.getQuestions();
        }
    }

    @GetMapping(value = "/getQuestions", produces = "application/json")
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @PostMapping(value = "/addQuestion", consumes = "application/json")
    public ResponseEntity<String> addQuestion(@RequestBody() Question question) {
        try {
            List<Question> questions = questionService.findAllByIds(question.getQuestionId(), question.getTestId());
            if (questions.size() <= 0) {
                questionService.insertQuestion(question);
                return new ResponseEntity<String>("Question added", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Question not added", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.getMessage() + " Insertion Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteQuestion/{testId}/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer questionId, @PathVariable Integer testId) {
        try {
            if (questionId != null && testId != null) {
                questionService.deleteQuestion(questionId, testId);
                return new ResponseEntity<String>("Question Details Deleted Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Deletion Failed", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            return new ResponseEntity<String>("Deletion Failed", HttpStatus.BAD_REQUEST);
        }
    }
}

