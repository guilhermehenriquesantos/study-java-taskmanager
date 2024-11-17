package com.taskmanager.br.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.taskmanager.br.taskmanager.model.Task;
import com.taskmanager.br.taskmanager.repository.TaskRepository;
import com.taskmanager.br.taskmanager.repository.TaskRepositoryH2;

@Controller
public class TaskController {

    @Autowired
    private TaskRepositoryH2 taskRepositoryH2;
    
    // private TaskRepository taskRepository;
    // // Contrutor para injetar o repositório
    // public TaskController() {
    //     this.taskRepository = new TaskRepository();
    // }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskRepositoryH2.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String description) {
        Task task = new Task();
        task.setDescription(description);
        task.setCompleted(false);
        taskRepositoryH2.save(task);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepositoryH2.deleteById(id);
        return "redirect:/";
    }

}
