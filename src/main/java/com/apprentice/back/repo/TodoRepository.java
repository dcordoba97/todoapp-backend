package com.apprentice.back.repo;

import java.util.Date;
import java.util.HashMap;
import com.apprentice.back.domain.TodoItem;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {
    private Integer idCounter = 0;
    private final HashMap<Integer, TodoItem> todoItems = new HashMap<>();

    public TodoItem readTodoItem(Integer id) {
        return todoItems.get(id);
    }

    public HashMap<Integer, TodoItem> readTodoItems() {
        return todoItems;
    }

    public TodoItem updateTodoItem(Integer id, TodoItem data) {
        TodoItem target = todoItems.get(id);

        if (target == null) return null;
        if (data.getName() != null) target.setName(data.getName());
        if (data.getDescription() != null) target.setDescription(data.getDescription());
        if (data.getDueDate() != null) target.setDueDate(data.getDueDate());
        if (data.getPriority() != null) target.setPriority(data.getPriority());
        todoItems.put(id, target);
        return todoItems.get(id);
    }

    public HashMap<Integer, TodoItem> deleteTodoItem(Integer id) {
        TodoItem target = todoItems.get(id);

        if (target == null) return null;
        todoItems.remove(id);
        return todoItems;
    }

    public TodoItem createTodoItem(TodoItem todoItem) {
        idCounter++;
        String name = todoItem.getName();
        String description = todoItem.getDescription();
        Date dueDate = todoItem.getDueDate();
        String priority = todoItem.getPriority();
        TodoItem newTodoItem = new TodoItem(idCounter, name, description, false, dueDate, priority);

        todoItems.put(idCounter, newTodoItem);
        return todoItems.get(idCounter);
    }

}
