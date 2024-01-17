package com.hexagonal.tasks.domain.ports.outputs;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;

public interface TaskRepositoryPort {
    Task save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    Optional<Task> updated(Task task);

    boolean deleteById(Long id);
}