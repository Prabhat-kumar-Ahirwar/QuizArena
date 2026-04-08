package com.example.QuizArena.Repository;

import com.example.QuizArena.Model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuestionTextContainingIgnoreCase(String keyword);

    List<Question> findByDifficultyLevelIgnoreCase(String level);
    @Query("SELECT q FROM Question q WHERE q.title LIKE %:keyword% OR q.description LIKE %:keyword%")
    Page<Question> findByKeyword(@Param("keyword") String keyword, Pageable pageable);
}