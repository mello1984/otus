package ru.butakov.otus.hw01.presenter;

import ru.butakov.otus.hw01.service.QuizPresenter;
import ru.butakov.otus.hw01.service.domain.Answer;
import ru.butakov.otus.hw01.service.domain.Question;

import java.text.MessageFormat;

public class CliQuizPresenterImpl implements QuizPresenter {

    private static final String QUESTION_SEPARATOR_START = ">>>>>>>>>>";
    private static final String QUESTION_SEPARATOR_END = "<<<<<<<<<<";
    private static final String QUESTION_PATTERN = "Question: {0}";
    private static final String ANSWER_PATTERN = "Answer {0}: {1}";

    @Override
    public void showQuestion(Question question) {
        System.out.println(QUESTION_SEPARATOR_START);
        System.out.println(mapQuestionToText(question));
        question.answers().forEach(answer -> System.out.println(mapAnswerToText(answer)));
        System.out.println(QUESTION_SEPARATOR_END);
    }

    private String mapQuestionToText(Question question) {
        return MessageFormat.format(QUESTION_PATTERN, question.text());
    }

    private String mapAnswerToText(Answer answer) {
        return MessageFormat.format(ANSWER_PATTERN, answer.number(), answer.text());
    }
}
