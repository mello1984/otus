package ru.butakov.otus.hw01.provider.csv.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class QuestionCsvModel {
    @CsvBindByName(column = "question_number")
    Integer number;
    @CsvBindByName(column = "text")
    String text;
}
