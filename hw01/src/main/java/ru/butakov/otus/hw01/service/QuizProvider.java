package ru.butakov.otus.hw01.service;

import ru.butakov.otus.hw01.service.domain.Question;

import java.util.List;

public interface QuizProvider {
    List<Question> provideQuestions();
}
