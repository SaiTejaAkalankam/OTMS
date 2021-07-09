package com.cg.anurag.qs.dao;

import com.cg.anurag.qs.dto.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDAO extends MongoRepository<Question, Integer> {

}
