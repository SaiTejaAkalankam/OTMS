package com.ooad.service;

import com.ooad.dao.QuestionDAO;
import com.ooad.dto.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO qdao;

    public void setqdao(QuestionDAO qdao) {
        this.qdao = qdao;
    }

    @Transactional
    public List<Question> findAllByIds(int questionId, int testId) {
        return qdao.findAll().stream().filter(question -> question.getQuestionId() == questionId && question.getTestId() == testId).collect(Collectors.toList());
    }

    @Transactional
    public Optional<Question> getQuestion(int questionId) {
        return qdao.findById(questionId);
    }

    @Transactional
    public List<Question> findAllByTestId(int testId) {
        return qdao.findAll().stream().filter(question -> question.getTestId() == testId).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Question> getQuestions() {
        return qdao.findAll();
    }

    @Transactional
    public Question insertQuestion(Question question) {
        return qdao.save(question);
    }

    @Transactional
    public String deleteQuestion(int questionId, int testId) {
        List<Question> questions = findAllByIds(questionId, testId);
        for (Question question : questions) {
            qdao.delete(question);
        }
        return "Question Details Deleted";
    }
}
