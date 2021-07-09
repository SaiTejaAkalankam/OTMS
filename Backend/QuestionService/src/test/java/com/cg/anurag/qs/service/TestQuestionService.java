//package com.cg.anurag.qs.service;
//import java.util.Optional;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.cg.anurag.qs.dto.Question;
//@SpringBootTest
//public class TestQuestionService
//{
//	@Autowired
//    QuestionService questionService;
//
//
//    @Test
//    public void testgetQuestion_Positive() throws Exception
//    {
//  	    Optional<Question> question = questionService.getQuestion(4);
//  	    Assertions.assertEquals(true,question.isPresent());
//    }
//
//    @Test
//    public void testgetQuestion_Negative() throws Exception
//    {
//  	    Optional<Question> question = questionService.getQuestion(22);
//  	    Assertions.assertEquals(false,question.isPresent());
//    }
//
//    @Test
//    public void testinsertQuestion_Positive() throws Exception
//    {
//  	  Question question = new Question(21,null, "Operator that is overloaded for object cout?",">>","<<","/",1,2);
//  	  Question q = questionService.insertQuestion(question);
//  	  Assertions.assertEquals(q.getQuestionId(), question.getQuestionId());
//    }
//
//    @Test
//    public void testinsertQuestion_update_Negative() throws Exception
//    {
//  	  Question question = new Question(21,null, "Operator that is overloaded for object 'cout'?",">>","<<","/",1,2);
//  	  Question q = questionService.insertQuestion(question);
//  	  Assertions.assertEquals(q.getQuestionId(), question.getQuestionId());
//    }
//
//    @Test
//    public void testdeleteQuestion_Positive() throws Exception
//    {
//    	questionService.deleteQuestion(21);
//    	Optional<Question> q = questionService.getQuestion(21);
//    	Assertions.assertEquals(false,q.isPresent());
//
//    }
//}
