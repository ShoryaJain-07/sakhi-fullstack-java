package team.tp_acsi_api.controllers;

import team.tp_acsi_api.models.Quiz;
import team.tp_acsi_api.requests.QuizRequest;
import team.tp_acsi_api.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizRequest quiz) {
        String question = quiz.getQuestion();
        String option1 = quiz.getOption1();
        String option2 = quiz.getOption2();
        String option3 = quiz.getOption3();
        String option4 = quiz.getOption4();
        String answer = quiz.getAnswer();
        Quiz savedQuiz = quizService.createQuiz(question, option1, option2, option3, option4, answer);
        return new ResponseEntity<>(savedQuiz, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizs() {
        List<Quiz> quizs = quizService.getAllQuizs();
        return new ResponseEntity<>(quizs, HttpStatus.OK);
    }
}