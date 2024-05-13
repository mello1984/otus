package ru.butakov.otus.hw01.service;

import ru.butakov.otus.hw01.service.domain.QuestionDto;

import java.util.List;

public interface QuizProvider {
    List<QuestionDto> provideQuestions();
}
