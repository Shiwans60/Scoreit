package com.quizapp.Quizzing.Services;

import com.quizapp.Quizzing.Models.QuestionModel;
import com.quizapp.Quizzing.Models.Questionwrapper;
import com.quizapp.Quizzing.Models.QuizModel;
import com.quizapp.Quizzing.Models.Responsemodel;
import com.quizapp.Quizzing.Repo.Questionrepo;
import com.quizapp.Quizzing.Repo.Quizrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class QuizServices {
    @Autowired
    private Questionrepo questionrepo;
    @Autowired
    private Quizrepo quizrepo;

    public ResponseEntity<String> Createquiz(String Category, String title, Integer numQ){
        List<QuestionModel> questions = questionrepo.findRandomQuestionsByCategory(Category,numQ);
        QuizModel quiz = new QuizModel();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizrepo.save(quiz);
        return new ResponseEntity<>("created", HttpStatus.OK);

    }
    public ResponseEntity<List<Questionwrapper>> getQuizQuestions(String id){
        Optional<QuizModel> quiz = quizrepo.findById(id);
        List<QuestionModel> questionsfromdb = quiz.get().getQuestions();
        List<Questionwrapper> questionforusr = new ArrayList<>();
        for (QuestionModel question : questionsfromdb) {
            Questionwrapper questionwrapper = new Questionwrapper(question.getId(), question.getTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            questionforusr.add(questionwrapper);
        }
        return new ResponseEntity<>(questionforusr, HttpStatus.OK);
    }
    public ResponseEntity<Integer> calculateresult(String id, List<Responsemodel> responses){
        QuizModel quiz = quizrepo.findById(id).get();
        List<QuestionModel> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for (Responsemodel response : responses ){
            if(response.getResponse().equals(questions.get(i).getRightanswer())){
               right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }

}
