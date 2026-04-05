package com.example.QuizArena.Controller;

import com.example.QuizArena.Model.Question;
import com.example.QuizArena.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @PostMapping
    public Question create(@RequestBody Question q) {
        return service.create(q);
    }

    @GetMapping
    public List<Question> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Question update(@PathVariable Long id, @RequestBody Question q) {
        return service.update(id, q);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}