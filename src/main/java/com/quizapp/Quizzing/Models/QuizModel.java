package com.quizapp.Quizzing.Models;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Getter
@Setter
@Data
@Document(collection = "Quiz")
public class QuizModel {

    @MongoId(FieldType.STRING)
    private String id;

    @Indexed(unique = true)
    @NonNull
    private String title;

    @DBRef
    private List<QuestionModel> questions;

    public QuizModel() {

    }


}
