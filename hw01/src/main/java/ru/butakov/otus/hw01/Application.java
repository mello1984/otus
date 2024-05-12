package ru.butakov.otus.hw01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.butakov.otus.hw01.service.QuizService;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuizService quizService = context.getBean(QuizService.class);
        quizService.executeQuiz();
    }
}
