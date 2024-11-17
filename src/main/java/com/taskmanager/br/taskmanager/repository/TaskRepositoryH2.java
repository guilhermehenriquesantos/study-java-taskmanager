package com.taskmanager.br.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.br.taskmanager.model.Task;

public interface TaskRepositoryH2 extends JpaRepository<Task, Long>  {

}
