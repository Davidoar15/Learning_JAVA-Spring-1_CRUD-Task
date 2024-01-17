package com.hexagonal.tasks.domain.ports.inputs;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;

public interface RetrieveTaskUserCase {
    Optional<Task> getTask(Long id);
    List<Task> getAllTasks();
}
