package com.taskmanager.br.taskmanager.repository;

import com.taskmanager.br.taskmanager.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    public List<Task> findAll(){
        return tasks;
    }

    public void save(Task task){
        task.setId(idCounter.incrementAndGet());
        tasks.add(task);
    }

    public void deleteById(Long id){
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
