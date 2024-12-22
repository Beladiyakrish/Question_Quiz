package com.example.Question_Quiz.Service;

import com.example.Question_Quiz.Model.Question;
import com.example.Question_Quiz.Model.QuizSession;
import com.example.Question_Quiz.Model.QuizSummary;
import com.example.Question_Quiz.Repository.QuestionRepository;
import com.example.Question_Quiz.Repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public QuizSession startQuiz(Long userId) {
        QuizSession session = new QuizSession();
        session.setUserId(userId);
        session.setStartTime(new Date());
        quizSessionRepository.save(session);
        return session;
    }

    public Question getRandomQuestion(Long sessionId) {
        List<Question> allQuestions = questionRepository.findAll();
        if(allQuestions.isEmpty()){
            throw new NoSuchElementException("No more questions available for this session");
        }
        Random random = new Random();
        return allQuestions.get(random.nextInt(allQuestions.size()));
    }

    public boolean submitAnswer(Long sessionId, Long questionId, String answer) {
        QuizSession session = quizSessionRepository.findById(sessionId).orElseThrow();
        Question question = getRandomQuestion(sessionId);
        System.out.println(question);
        boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(answer);

        if (isCorrect) {
            session.incrementCorrectAnswers();
        } else {
            session.incrementIncorrectAnswers();
        }

        quizSessionRepository.save(session);
        return isCorrect;
    }

    public QuizSummary getQuizSummary(Long sessionId) {
        QuizSession session = quizSessionRepository.findById(sessionId).orElseThrow();
        return new QuizSummary(session.getCorrectAnswers(), session.getIncorrectAnswers());
    }
}