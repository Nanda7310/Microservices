package com.nandu.QuestionService.controller;


import com.nandu.QuestionService.model.Question;
import com.nandu.QuestionService.model.QuestionWrapper;
import com.nandu.QuestionService.model.Response;
import com.nandu.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")

public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions()
    {

        return questionService.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory( @PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);

    }
    @PostMapping("/addQuestion")
    public ResponseEntity <String> addQuestion( @RequestBody Question question)
    {
      return questionService.addQuestion(question);

    }
//    @GetMapping("/generate")
//    public ResponseEntity<List<Integer>> getQuestionForQuiz
//            (@RequestParam String categoryName ,@RequestParam Integer numOfQuestions)
//    {
//        return questionService.getQuestionForQuiz(categoryName,numOfQuestions);
//    }
    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds)
    {
        return  questionService.getQuestionFromId(questionIds);
    }
    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return questionService.getScore(responses);

    }


}
