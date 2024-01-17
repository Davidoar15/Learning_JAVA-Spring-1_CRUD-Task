package com.hexagonal.tasks.infrastructure.entities;

import java.time.LocalDateTime;

import com.hexagonal.tasks.domain.models.Task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

    public TaskEntity() {}

    public TaskEntity(Long id, String title, String description, LocalDateTime creationDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.completed = completed;
    }

    public static TaskEntity fromDomainModel(Task task) {
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(), task.getCompleted());
    }

    public Task toDomainModel() {
        return new Task(id, title, description, creationDate, completed);
    }

    // ? Getters and Setters

        // * id
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }

        // * title
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }

        // * description
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

        // * creationDate
        public LocalDateTime getCreationDate() {
            return creationDate;
        }
        public void setCreationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
        }

        // * completed
        public boolean getCompleted() {
            return completed;
        }
        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

    // ? Getters and Setters
}
