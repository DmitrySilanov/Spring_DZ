package com.silanov.HW_5.service;

import com.silanov.HW_5.domain.Task;
import com.silanov.HW_5.domain.TaskStatus;
import com.silanov.HW_5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public Task updateTaskStatus(Long id, Task newTask) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(newTask.getStatus());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task with id: " + id + " not found.");
        }
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findAllByStatus(status);
    }


}