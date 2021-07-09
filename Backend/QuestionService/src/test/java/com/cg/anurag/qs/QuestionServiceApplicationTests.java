package com.cg.anurag.qs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cg.anurag.qs.dto.Question;
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class QuestionServiceApplicationTests 
{
	@Autowired
	TestRestTemplate testRestTemplate;
	public void setTestRestTemplate(TestRestTemplate testRestTemplate)
	{
		this.testRestTemplate=testRestTemplate;
	}
	
	@LocalServerPort
	int localServerPort;
	
//	@Test
//	public void testgetQuestion_Positive() throws Exception
//	{
//		 String url="http://localhost:"+localServerPort+"getQuestion/4";
//		 ResponseEntity<Question> question = testRestTemplate.getForEntity(url,Question.class);
//		 Assertions.assertEquals(200, question.getStatusCodeValue());
//	}
	
	@Test
	public void testgetQuestion_Negative() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"getQuestion/22";
		 ResponseEntity<Question> question = testRestTemplate.getForEntity(url,Question.class);
		 Assertions.assertEquals(404, question.getStatusCodeValue());
	}
	
	@Test
	public void testaddQuestion_Positive() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"addQuestion";
		 Question question = new Question(21,null, " Operator that is overloaded for object cout?",">>","<<","/",1,2);
		 ResponseEntity<String> response = testRestTemplate.postForEntity(url,question,String.class);
		 Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void testaddQuestion_Negative() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"addQuestion";
		 Question question  = null;
		 ResponseEntity<String> response = testRestTemplate.postForEntity(url,question,String.class);
		 Assertions.assertNotEquals(HttpStatus.BAD_REQUEST, response.getStatusCodeValue());
	}
	
//	@Test
//	public void testdeleteQuestion_Positive() throws Exception
//	{
//		 String url="http://localhost:"+localServerPort+"deleteQuestion/21";
//		 @SuppressWarnings("unused")
//		HttpEntity<Integer> ent = new HttpEntity<>(21);
//		  ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
//		 Assertions.assertEquals(200, response.getStatusCodeValue());
//	}
	
//	@Test
//	public void testdeleteQuestion_Negative() throws Exception
//	{
//		 String url="http://localhost:"+localServerPort+"deleteQuestion/21";
//		 @SuppressWarnings("unused")
//		HttpEntity<Integer> ent = new HttpEntity<>(21);
//		  ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
//		 Assertions.assertNotEquals(400, response.getStatusCodeValue());
//	}

}
