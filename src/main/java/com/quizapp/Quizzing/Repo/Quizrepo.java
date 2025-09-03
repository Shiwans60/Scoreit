package com.quizapp.Quizzing.Repo;

import com.quizapp.Quizzing.Models.QuizModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface Quizrepo extends MongoRepository<QuizModel,String> {


}
