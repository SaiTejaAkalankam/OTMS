package com.cg.anurag.ls.dao;
import com.cg.anurag.ls.dto.Login;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginDAO extends MongoRepository<Login,String> {
}
