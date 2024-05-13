package ru.butakov.otus.hw01.presenter;

import ru.butakov.otus.hw01.service.QuizPresenter;
import ru.butakov.otus.hw01.service.domain.AnswerDto;
import ru.butakov.otus.hw01.service.domain.QuestionDto;

import java.text.MessageFormat;

public class CliQuizPresenterImpl implements QuizPresenter {
    private static final String QUESTION_SEPARATOR_START = ">>>>>>>>>>";
    private static final String QUESTION_SEPARATOR_END = "<<<<<<<<<<";
    private static final String QUESTION_PATTERN = "Question: {0}";
    private static final String ANSWER_PATTERN = "Answer {0}: {1}";

    @Override
    public void showQuestion(QuestionDto questionDto) {
        System.out.println(QUESTION_SEPARATOR_START);
        System.out.println(mapQuestionToText(questionDto));
        questionDto.answerDtos().forEach(answerDto -> System.out.println(mapAnswerToText(answerDto)));
        System.out.println(QUESTION_SEPARATOR_END);
    }

    private String mapQuestionToText(QuestionDto questionDto) {
        return MessageFormat.format(QUESTION_PATTERN, questionDto.text());
    }

    private String mapAnswerToText(AnswerDto answerDto) {
        return MessageFormat.format(ANSWER_PATTERN, answerDto.number(), answerDto.text());
    }
}
