package com.hexagonal.tasks.application.usecasses;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.inputs.RetrieveTaskUserCase;
import com.hexagonal.tasks.domain.ports.outputs.TaskRepositoryPort;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUserCase {
 
    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }

}
