package com.javaspring.quizservice.controller;


import com.javaspring.quizservice.dto.QuizDto;
import com.javaspring.quizservice.model.QuestionWrapper;
import com.javaspring.quizservice.model.Response;
import com.javaspring.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping(path = "/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestion(),quizDto.getTitle());
    }
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }

    @PostMapping(path = "submit/{id}")
        public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
        return quizService.calculateResult(id,response);
    }
}
