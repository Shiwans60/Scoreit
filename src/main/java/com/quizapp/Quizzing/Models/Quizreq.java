package com.quizapp.Quizzing.Models;

import lombok.Data;

@Data
public class Quizreq {
    private String category;
    private String title;
    private Integer numQ;
}
