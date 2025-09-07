package com.quizapp.Quizzing.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Questions")
public class QuestionModel {
    @Id
    private Integer id;
    private String Title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightanswer;
    private String difficultylvl;
    private String category;
}
