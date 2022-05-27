package com.samuraism.javatraining.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@org.springframework.stereotype.Controller
public class TodoController {

    @Autowired
    TaskRepository repository;

    @GetMapping("/todo")
    String showTodos(Model model) {
        List<Task> tasks = repository.findAll();
        model.addAttribute("tasks", tasks);
        return "todo";
    }

    @PostMapping("/addTask")
    String addTask(@RequestParam String taskContent) {
        Task task = new Task();
        task.setText(taskContent);
        repository.save(task);
        return "redirect:/todo";
    }

    @PostMapping("/removeTask")
    String addTask(@RequestParam int id) {
        Task task = new Task();
        task.setId(id);
        repository.delete(task);
        return "redirect:/todo";
    }
}
