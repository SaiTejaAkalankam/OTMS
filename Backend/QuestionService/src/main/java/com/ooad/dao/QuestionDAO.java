package com.ooad.dao;

import com.ooad.dto.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDAO extends MongoRepository<Question, Integer> {

}
