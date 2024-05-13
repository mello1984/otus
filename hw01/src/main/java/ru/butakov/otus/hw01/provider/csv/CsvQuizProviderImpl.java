package ru.butakov.otus.hw01.provider.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import ru.butakov.otus.hw01.provider.csv.domain.AnswerCsvModel;
import ru.butakov.otus.hw01.provider.csv.domain.QuestionCsvModel;
import ru.butakov.otus.hw01.service.QuizProvider;
import ru.butakov.otus.hw01.service.domain.AnswerDto;
import ru.butakov.otus.hw01.service.domain.QuestionDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvQuizProviderImpl implements QuizProvider {
    private static final char CSV_SEPARATOR = ',';
    private final List<QuestionDto> QUESTIONS;

    @Override
    public List<QuestionDto> provideQuestions() {
        return List.copyOf(QUESTIONS);
    }

    @SneakyThrows
    public CsvQuizProviderImpl() {
        var answers = parseCsvResource("/csv/quiz-answers.csv", AnswerCsvModel.class)
                .stream()
                .collect(Collectors.groupingBy(AnswerCsvModel::getQuestionNumber));
        var questionCsvModels = parseCsvResource("/csv/quiz-questions.csv", QuestionCsvModel.class);
        QUESTIONS = buildQuestions(questionCsvModels, answers);
    }

    private <T> List<T> parseCsvResource(String fileName, Class<T> clazz) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource(fileName).getInputStream()))) {
            return new CsvToBeanBuilder<T>(reader)
                    .withSeparator(CSV_SEPARATOR)
                    .withType(clazz)
                    .build()
                    .parse();
        }
    }

    private List<QuestionDto> buildQuestions(List<QuestionCsvModel> questionCsvModels, Map<Integer, List<AnswerCsvModel>> answers) {
        return questionCsvModels
                .stream()
                .map(questionCsvModel -> new QuestionDto(
                                questionCsvModel.getNumber(),
                                questionCsvModel.getText(),
                                buildAnswers(questionCsvModel.getNumber(), answers)
                        )
                )
                .collect(Collectors.toList());
    }

    private List<AnswerDto> buildAnswers(Integer number, Map<Integer, List<AnswerCsvModel>> answers) {
        return answers.getOrDefault(number, Collections.emptyList())
                .stream()
                .map(answerCsvModel -> new AnswerDto(
                                answerCsvModel.getAnswerNumber(),
                                answerCsvModel.getText(),
                                answerCsvModel.getIsCorrect()
                        )
                )
                .collect(Collectors.toList());
    }
}
