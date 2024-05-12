package ru.butakov.otus.hw01.service.domain;

import java.util.List;

public record Question(String text, List<Answer> answers) {
}
