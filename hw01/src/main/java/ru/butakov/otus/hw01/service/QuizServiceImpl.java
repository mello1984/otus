package ru.butakov.otus.hw01.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QuizServiceImpl implements QuizService {
    QuizProvider quizProvider;
    QuizPresenter quizPresenter;

    public QuizServiceImpl(QuizProvider quizProvider, QuizPresenter quizPresenter) {
        this.quizProvider = quizProvider;
        this.quizPresenter = quizPresenter;
    }

    @Override
    public void executeQuiz() {
        var questions = quizProvider.provideQuestions();
        questions.forEach(quizPresenter::showQuestion);
    }
}
