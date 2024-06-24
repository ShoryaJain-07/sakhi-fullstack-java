package team.tp_acsi_api.services;

import team.tp_acsi_api.models.Quiz;
import team.tp_acsi_api.repositories.QuizRepository;
import team.tp_acsi_api.requests.QuizRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(String question, String option1, String option2, String option3, String option4, String answer) {

        Quiz quiz = new Quiz();
        quiz.setQuestion(question);
        quiz.setOption1(option1);
        quiz.setOption2(option2);
        quiz.setOption3(option3);
        quiz.setOption4(option4);
        quiz.setAnswer(answer);

        this.quizRepository.save(quiz);

        return quiz;
    }

    public List<Quiz> getAllQuizs() {
        return quizRepository.findAll();
    }
}