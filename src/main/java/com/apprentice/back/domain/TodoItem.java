package com.apprentice.back.domain;

import java.util.Date;

public class TodoItem {

    private String priority;

    private String name;
    private String description;
    private Boolean isDone;
    private Integer id;
    private Date dueDate;



    public TodoItem(Integer id, String name, String description, Boolean isDone, Date dueDate, String priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isDone = isDone;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean done) {
        isDone = done;
    }

    public Date getDueDate() { return dueDate; }

    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public String getPriority() { return priority; }

    public void setPriority(String priority) { this.priority = priority; }
}
