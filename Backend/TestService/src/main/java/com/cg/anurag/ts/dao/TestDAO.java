package com.cg.anurag.ts.dao;

import com.cg.anurag.ts.dto.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDAO extends MongoRepository<Test, Integer> {

}