package com.wutapestry.form.models;
import java.util.UUID;
import java.time.LocalDate;


public class TaskModel {
    private String id;
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }
    private String title;
    private String description;
    private String priority;
    public String getPriority() {
        return priority;
    }


    public void setPriority(String priority) {
        this.priority = priority;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }
    private String color;
    private LocalDate dateCompleted;
    private LocalDate dateCreated;
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }


    public void setStatus(Boolean status) {
        this.status = status;
    }


    public TaskModel(){
        LocalDate today = LocalDate.now();
        UUID uniqueId = UUID.randomUUID();
        String idString = uniqueId.toString();
        this.id = idString;
        this.status = false;
        this.dateCreated = today;
    }


    public LocalDate getDateCompleted() {
        return dateCompleted;
    }
    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
    public LocalDate getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
