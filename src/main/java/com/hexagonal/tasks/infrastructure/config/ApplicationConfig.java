package com.hexagonal.tasks.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.application.usecasses.CreateTaskUseCaseImpl;
import com.hexagonal.tasks.application.usecasses.DeleteTaskUseCaseImpl;
import com.hexagonal.tasks.application.usecasses.GetAdditionalTaskInfoUseCaseImpl;
import com.hexagonal.tasks.application.usecasses.RetrieveTaskUseCaseImpl;
import com.hexagonal.tasks.application.usecasses.UpdateTaskUseCaseImpl;
import com.hexagonal.tasks.domain.ports.inputs.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.outputs.ExternalServicePort;
import com.hexagonal.tasks.domain.ports.outputs.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.tasks.infrastructure.repositories.JpaTaskRepositoryAdapter;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
            new CreateTaskUseCaseImpl(taskRepositoryPort), 
            new RetrieveTaskUseCaseImpl(taskRepositoryPort), 
            new UpdateTaskUseCaseImpl(taskRepositoryPort), 
            new DeleteTaskUseCaseImpl(taskRepositoryPort),
            getAdditionalTaskInfoUseCase 
        ); 
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean 
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }
}
