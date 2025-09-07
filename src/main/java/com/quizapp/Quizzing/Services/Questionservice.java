package com.quizapp.Quizzing.Services;

import com.quizapp.Quizzing.Models.QuestionModel;
import com.quizapp.Quizzing.Models.QuizModel;
import com.quizapp.Quizzing.Repo.Questionrepo;
import com.quizapp.Quizzing.Repo.Quizrepo;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class Questionservice {
    @Autowired
    private Questionrepo questionrepo;

    @Autowired
    private QuizServices quizServices;
    @Autowired
    private Quizrepo quizrepo;

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







    @Transactional
    public ResponseEntity<String> addquestion(QuestionModel questionmodel,String title,String Category,Integer numQ){
        try{
            QuizModel quiz = quizServices.findbytitle(title);
            if (quiz == null) {
                return new ResponseEntity<>("Quiz not found", HttpStatus.NOT_FOUND);
            }
            QuestionModel saved = questionrepo.save(questionmodel);


            //QuizModel quizModel = quiz.getBody();
            quiz.getQuestions().add(saved);
            //quiz.setTitle(null);
            quizrepo.save(quiz);
            //quizServices.Createquiz(quiz.getTitle(), Category, numQ);
            return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //{
          //  return new ResponseEntity<>("Question already exists", HttpStatus.CONFLICT) ;
        //}
    }

}
