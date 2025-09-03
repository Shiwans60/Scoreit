package com.quizapp.Quizzing.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class Questionwrapper {
    @Id
    private Integer id;
    private String title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public Questionwrapper(Integer id, String title, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.title = title;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;

    }
}
