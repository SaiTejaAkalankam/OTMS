package com.ooad.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ooad.util.ObjectIDJacksonSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("question")
public class Question {

    @Id
    @JsonSerialize(using = ObjectIDJacksonSerializer.class)
    private ObjectId id;
    private int questionId;
    private int testId;
    private String questionContent;
    private String option1;
    private String option2;
    private String option3;
    private int marks;
    private int answerOption;

    public Question() {
    }

    public Question(int questionId, int testId, String questionContent, String option1, String option2, String option3, int marks,
                    int answerOption) {
        super();
        this.questionId = questionId;
        this.testId = testId;
        this.questionContent = questionContent;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.marks = marks;
        this.answerOption = answerOption;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int test) {
        this.testId = test;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(int answerOption) {
        this.answerOption = answerOption;
    }

}
