package com.quizapp.Quizzing.Controller;

import com.quizapp.Quizzing.Models.Questionwrapper;
import com.quizapp.Quizzing.Models.Quizreq;
import com.quizapp.Quizzing.Models.Responsemodel;
import com.quizapp.Quizzing.Services.QuizServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping("/myquiz")
public class Quizcontroller {
    @Autowired
    private QuizServices quizServices;
    @PostMapping("/create")
    public ResponseEntity<String> createquiz(@RequestBody Quizreq quizreq){ // to visit manage this dto
        return quizServices.Createquiz(quizreq.getCategory(),quizreq.getTitle(), quizreq.getNumQ());

    }
    @GetMapping("getquiz/{id}")
    public ResponseEntity<List<Questionwrapper>> getquizquestions(@PathVariable String id){
        return quizServices.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitquiz(@PathVariable String id, @RequestBody List<Responsemodel> responses){
        return quizServices.calculateresult(id, responses);
    }

}
