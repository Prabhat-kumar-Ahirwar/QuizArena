package com.example.QuizArena.Controller;

import com.example.QuizArena.Model.Quiz;
import com.example.QuizArena.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService service;

    @PostMapping
    public Quiz create(@RequestParam String title,
                       @RequestBody List<Long> questionIds) {
        return service.create(title, questionIds);
    }

    @GetMapping
    public List<Quiz> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Quiz update(@PathVariable Long id, @RequestBody Quiz quiz) {
        return service.update(id, quiz);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}