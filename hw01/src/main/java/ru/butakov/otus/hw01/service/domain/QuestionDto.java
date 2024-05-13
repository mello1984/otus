package ru.butakov.otus.hw01.service.domain;

import java.util.List;

public record QuestionDto(int number, String text, List<AnswerDto> answerDtos) {
}
