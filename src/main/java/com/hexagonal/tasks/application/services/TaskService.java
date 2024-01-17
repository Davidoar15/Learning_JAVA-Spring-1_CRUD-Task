package com.hexagonal.tasks.application.services;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.inputs.CreateTaskUseCase;
import com.hexagonal.tasks.domain.ports.inputs.DeleteTaskUseCase;
import com.hexagonal.tasks.domain.ports.inputs.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.inputs.RetrieveTaskUserCase;
import com.hexagonal.tasks.domain.ports.inputs.UpdateTaskUseCase;

public class TaskService implements CreateTaskUseCase, RetrieveTaskUserCase, UpdateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;

    private final RetrieveTaskUserCase retrieveTaskUseCase;

    private final UpdateTaskUseCase updateTaskUseCase;

    private final DeleteTaskUseCase deleteTaskUseCase;

    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    public TaskService(CreateTaskUseCase createTaskUseCase, RetrieveTaskUserCase retrieveTaskUseCase, UpdateTaskUseCase updateTaskUseCase, DeleteTaskUseCase deleteTaskUseCase, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return updateTaskUseCase.updateTask(id, updatedTask);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }
    
}
