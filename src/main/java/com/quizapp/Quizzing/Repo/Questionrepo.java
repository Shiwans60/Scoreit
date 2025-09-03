package com.quizapp.Quizzing.Repo;

import com.quizapp.Quizzing.Models.QuestionModel;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Questionrepo extends MongoRepository<QuestionModel, String> {
    List<QuestionModel> findByCategory(String category);
    @Aggregation(pipeline = {
            "{'$match' : {'category': ?0} }",
            "{'$sample' : {'size' : ?1} }"
    })
    List<QuestionModel> findRandomQuestionsByCategory(String Category,int numQ);
}
