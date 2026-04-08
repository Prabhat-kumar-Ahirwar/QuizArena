package com.example.QuizArena.Service;

import com.example.QuizArena.Model.Question;
import com.example.QuizArena.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repo;

    public Question create(Question q) {
        return repo.save(q);
    }

    public Page<Question> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Question getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Question update(Long id, Question newQ) {
        Question q = repo.findById(id).orElse(null);
        if (q != null) {
            q.setQuestion(newQ.getQuestion());
            q.setOptionA(newQ.getOptionA());
            q.setOptionB(newQ.getOptionB());
            q.setOptionC(newQ.getOptionC());
            q.setOptionD(newQ.getOptionD());
            q.setCorrectAnswer(newQ.getCorrectAnswer());
            return repo.save(q);
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


    public List<Question> getByDifficulty(String level) {
        return repo.findByDifficultyLevelIgnoreCase(level);
    }
    public Page<Question> search(String keyword, Pageable pageable) {
        return repo.findByKeyword(keyword, pageable);
    }
}