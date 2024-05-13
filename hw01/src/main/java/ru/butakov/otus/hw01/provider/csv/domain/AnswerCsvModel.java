package ru.butakov.otus.hw01.provider.csv.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class AnswerCsvModel {
    @CsvBindByName(column = "question_number")
    Integer questionNumber;
    @CsvBindByName(column = "answer_number")
    Integer answerNumber;
    @CsvBindByName(column = "text")
    String text;
    @CsvBindByName(column = "is_correct")
    Boolean isCorrect;
}
