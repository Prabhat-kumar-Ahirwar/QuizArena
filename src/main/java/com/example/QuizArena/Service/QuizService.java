package com.example.QuizArena.Service;

import com.example.QuizArena.Model.Question;
import com.example.QuizArena.Model.Quiz;
import com.example.QuizArena.Repository.QuestionRepository;
import com.example.QuizArena.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepo;

    @Autowired
    private QuestionRepository questionRepo;

    public Quiz create(String title, List<Long> questionIds) {
        List<Question> questions = questionRepo.findAllById(questionIds);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        return quizRepo.save(quiz);
    }

    public Page<Quiz> getAll(Pageable pageable) {
        return quizRepo.findAll(pageable);
    }

    public Quiz getById(Long id) {
        return quizRepo.findById(id).orElse(null);
    }

    public Quiz update(Long id, Quiz newQuiz) {
        Quiz quiz = quizRepo.findById(id).orElse(null);
        if (quiz != null) {
            quiz.setTitle(newQuiz.getTitle());
            quiz.setQuestions(newQuiz.getQuestions());
            return quizRepo.save(quiz);
        }
        return null;
    }

    public void delete(Long id) {
        quizRepo.deleteById(id);
    }
}