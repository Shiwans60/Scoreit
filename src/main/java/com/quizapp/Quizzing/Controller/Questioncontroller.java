package com.quizapp.Quizzing.Controller;

import com.quizapp.Quizzing.Models.QuestionModel;
import com.quizapp.Quizzing.Services.Questionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Questions")
public class Questioncontroller {
    @Autowired
    private Questionservice questionservice;

    @PostMapping("/addquestions")
    public ResponseEntity<String> putquestions(@RequestBody QuestionModel questions){
        return questionservice.addquestion(questions);
    }
    @GetMapping("/getallquestions")
    public ResponseEntity<List<QuestionModel>> getallquestions(){
        ResponseEntity<List<QuestionModel>> getting =  questionservice.getallquestions();
        return getting;
    }
    @GetMapping("/getbycategory/{category}")
    public ResponseEntity<List<QuestionModel>> getbycategory(@PathVariable String category){
        ResponseEntity<List<QuestionModel>> getting = questionservice.getallquestionsbycategory(category);
        return getting;
    }


}
