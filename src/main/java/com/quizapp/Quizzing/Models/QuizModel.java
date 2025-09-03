package com.quizapp.Quizzing.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Data
@Document(collection = "Quiz")
public class QuizModel {
    @MongoId(FieldType.STRING)
    private String id;
    private String title;
    @DBRef
    private List<QuestionModel> questions;
}
