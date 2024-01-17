package com.hexagonal.tasks.application.usecasses;

import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.inputs.UpdateTaskUseCase;
import com.hexagonal.tasks.domain.ports.outputs.TaskRepositoryPort;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
    
    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepositoryPort.updated(updatedTask);
    }

}
