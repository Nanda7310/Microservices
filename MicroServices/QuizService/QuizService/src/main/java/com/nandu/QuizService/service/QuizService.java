package com.nandu.QuizService.service;


import com.nandu.QuizService.dao.QuizDao;
import com.nandu.QuizService.feign.QuizInterface;
import com.nandu.QuizService.model.QuestionWrapper;
import com.nandu.QuizService.model.Quiz;
import com.nandu.QuizService.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
 QuizInterface quizInterface;




    public ResponseEntity<List<QuestionWrapper>>  getQuizQuestion(Integer id) {
      Quiz quiz= quizDao.findById(id).get();
      List<Integer> questionIds=quiz.getQuestions();

        ResponseEntity<List<QuestionWrapper>> questions= quizInterface.getQuestionFromId(questionIds);





       return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score=quizInterface.getScore(responses);

        return score;
    }
}
