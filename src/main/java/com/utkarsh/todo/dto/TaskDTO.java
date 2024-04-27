package com.utkarsh.todo.dto;

public class TaskDTO {
    private String title;
    private boolean isCompleted;

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    public TaskDTO(String title, boolean isCompleted) {
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public TaskDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
