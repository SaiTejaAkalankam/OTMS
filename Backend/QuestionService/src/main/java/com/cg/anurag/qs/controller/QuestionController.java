package com.cg.anurag.qs.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.anurag.qs.dto.Question;
import com.cg.anurag.qs.service.QuestionService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuestionController {
	@Autowired
	QuestionService questionService;
	public void setQuestionService(QuestionService questionService)
	{
		this.questionService=questionService;
	}
	
	@GetMapping(value="/getQuestion/{questionId}", produces="application/json")
	  public ResponseEntity<Optional<Question>> getQuestion(@PathVariable int questionId)
	  {
		   Optional<Question> question = questionService.getQuestion(questionId);
		   if(question.isPresent())
			   return new ResponseEntity<Optional<Question>>(question,HttpStatus.OK);
		   return new ResponseEntity<Optional<Question>>(question,HttpStatus.NOT_FOUND);
	  }
	
     @GetMapping(value="/getQuestions",produces="application/json")
     public List<Question> getQuestions()
     {
	   return questionService.getQuestions();
     }
     
     @PostMapping(value="/addQuestion",consumes="application/json")
     public ResponseEntity<String> addQuestion(@RequestBody()Question question)
     {
   	  try
   	  {
   	      questionService.insertQuestion(question);
   	      return new ResponseEntity<String>("Question Added",HttpStatus.OK);
   	  }
   	  catch(Exception ex)
   	  {
   	    	return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);
   	  } 
     }
     
     
     @DeleteMapping("/deleteQuestion/{questionId}")
     public ResponseEntity<String> deleteQuestion(@PathVariable int questionId)
     {
  	   try
  	   {
  		   questionService.deleteQuestion(questionId);
  		   return new ResponseEntity<String>("Question Details Deleted Successfully",HttpStatus.OK);
  	   }
  	   catch(Exception ex)
  	 	  {
  	 		 return new ResponseEntity<String>("Deletion Failed",HttpStatus.BAD_REQUEST);
  	 	  }
     }
}

