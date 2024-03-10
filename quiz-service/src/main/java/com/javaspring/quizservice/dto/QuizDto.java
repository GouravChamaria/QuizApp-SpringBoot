package com.javaspring.quizservice.dto;

import lombok.Data;

@Data
public class QuizDto {
    String categoryName;
    Integer numQuestion;
    String title;
}
