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

    @PostMapping("/addquestions/{title}/{Category}/{numQ}")
    public ResponseEntity<String> putquestions(@RequestBody QuestionModel questions,@PathVariable("title") String title,
                                               @PathVariable("Category") String Category,
                                               @PathVariable("numQ") Integer numQ){
        return questionservice.addquestion(questions,title,Category,numQ);
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
