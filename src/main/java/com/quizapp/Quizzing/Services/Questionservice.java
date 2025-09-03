package com.quizapp.Quizzing.Services;

import com.quizapp.Quizzing.Models.QuestionModel;
import com.quizapp.Quizzing.Repo.Questionrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Questionservice {
    @Autowired
    private Questionrepo questionrepo;
    public ResponseEntity<List<QuestionModel>> getallquestions(){
        try{
            return new ResponseEntity<>(questionrepo.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<List<QuestionModel>> getallquestionsbycategory(String category){
        try{
            return new ResponseEntity<>(questionrepo.findByCategory(category),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addquestion(QuestionModel questionmodel){
        questionrepo.save(questionmodel);
        return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED) ;
    }


}
