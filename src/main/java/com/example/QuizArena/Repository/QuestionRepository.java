package com.example.QuizArena.Repository;

import com.example.QuizArena.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuestionRepository extends JpaRepository<Question, Long> {}