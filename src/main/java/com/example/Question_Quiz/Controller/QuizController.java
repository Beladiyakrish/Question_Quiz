package com.example.Question_Quiz.Controller;

import com.example.Question_Quiz.Model.Question;
import com.example.Question_Quiz.Model.QuizSession;
import com.example.Question_Quiz.Model.QuizSummary;
import com.example.Question_Quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<QuizSession> startQuiz(@RequestParam Long userId) {
        return ResponseEntity.ok(quizService.startQuiz(userId));
    }

    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion(@RequestParam Long sessionId) {
        return ResponseEntity.ok(quizService.getRandomQuestion(sessionId));
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitAnswer(@RequestParam Long sessionId, 
                                               @RequestParam Long questionId, 
                                               @RequestParam String answer) {
        boolean isCorrect = quizService.submitAnswer(sessionId, questionId, answer);
        return ResponseEntity.ok(isCorrect ? "Correct Answer!" : "Incorrect Answer.");
    }

    @GetMapping("/summary")
    public ResponseEntity<QuizSummary> getQuizSummary(@RequestParam Long sessionId) {
        return ResponseEntity.ok(quizService.getQuizSummary(sessionId));
    }
}
