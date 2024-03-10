package com.javaspring.questionservice.controller;

import com.javaspring.questionservice.model.Question;
import com.javaspring.questionservice.model.QuestionWrapper;
import com.javaspring.questionservice.model.Response;
import com.javaspring.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/question")
public class QuestionController {
    @Autowired
    Environment environment;
    @Autowired
    QuestionService questionService;

    @GetMapping(path = "/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();

    }
    @GetMapping(path = "/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);

    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Question>> getQuestion(@PathVariable int id){
        return questionService.getQuestion(id);
    }
    @PostMapping(path = "/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping (path = "/updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }
    @DeleteMapping(path = "/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions){
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping(path = "/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        System.out.println(environment.getProperty("server.port"));
        return questionService.getquestionsFromId(questionIds);
    }
    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

}
