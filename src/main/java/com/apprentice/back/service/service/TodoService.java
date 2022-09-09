package com.apprentice.back.service.service;

import java.util.HashMap;
import com.apprentice.back.domain.TodoItem;
import org.springframework.stereotype.Service;
import com.apprentice.back.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    public HashMap<Integer, TodoItem> readTodoItems () {
        return todoRepository.readTodoItems();
    }

    public TodoItem readTodoItem(Integer todoItemId) {
        return todoRepository.readTodoItem(todoItemId);
    }

    public HashMap<Integer, TodoItem> deleteTodoItem(Integer todoItemId) {
        return todoRepository.deleteTodoItem(todoItemId);
    }

    public TodoItem updateTodoItem(Integer id, TodoItem todoItem) {
        return todoRepository.updateTodoItem(id, todoItem);
    }

    public TodoItem createTodoItem(TodoItem todoItem) {
        return todoRepository.createTodoItem(todoItem);
    }
}
