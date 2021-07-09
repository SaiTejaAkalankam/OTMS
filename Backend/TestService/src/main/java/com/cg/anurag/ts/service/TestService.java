package com.cg.anurag.ts.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.anurag.ts.dao.TestDAO;
import com.cg.anurag.ts.dto.Test;
@Service
public class TestService 
{
    @Autowired
    TestDAO tdao;
    public void setTdao(TestDAO tdao) { this.tdao=tdao;}
    @Transactional
    public Test insertTest(Test test)
    {
        return tdao.save(test);
    }
    @Transactional(readOnly=true)
    public Optional<Test> getTestDetails(int testId)
    {
    	return tdao.findById(testId);
    }
    
    @Transactional(readOnly=true)
    public List<Test> getTests()
    {
    	return tdao.findAll();
    }
    @Transactional
    public String deleteTest(int testId)
    {
    	tdao.deleteById(testId);
    	return "Test Deleted";
    }
    
    @Transactional
    public String updateTest(Test newTest)
    {
    	Test test = tdao.findById(newTest.getTestId()).get();
    	if(test!=null)
    	{
    	  test.setTestDate(newTest.getTestDate());
    	  test.setTestTitle(newTest.getTestTitle());
    	  test.setTestDuration(newTest.getTestDuration());
    	  test.setTestTotalMarks(newTest.getTestTotalMarks());
    	  return "Test Modified";
    	}
    	return "Update Failed";
    }
	
}