package com.apprentice.back.controller;

import com.apprentice.back.domain.TodoItem;
import com.apprentice.back.service.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;


// http://localhost:9090
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class TodoController {

    // front-end         javaserver
    // Http request ---> Controller ---> Service ---> Repository
    //  front-end   <--- Controller <--- Service <---

    @Autowired
    private TodoService todoService;

    // fetch all todoItems from (database)
    @GetMapping("/api/todoItems")
    public ResponseEntity<?> getTodoItems() {
        HashMap<Integer, TodoItem> results = todoService.readTodoItems();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/api/todoItems/{todoItemId}")
    public ResponseEntity<?> getTodoItem(@PathVariable Integer todoItemId) {
        TodoItem result = todoService.readTodoItem(todoItemId);
        if (result == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TODO not found");
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/todoItems/{todoItemId}")
    public ResponseEntity<?> deleteTodoItem(@PathVariable Integer todoItemId) {
        HashMap<Integer, TodoItem> result = todoService.deleteTodoItem(todoItemId);
        if (result == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TODO not found");
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/todoItems/{todoItemId}")
    public HttpEntity<?> updateTodoItem(@PathVariable Integer todoItemId, @RequestBody TodoItem todoItem) {
        if (todoItemId == null) ResponseEntity.badRequest();
        TodoItem result = todoService.updateTodoItem(todoItemId, todoItem);
        if (result == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TODO not found");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/api/todoItems")
    public ResponseEntity<?> createTodoItem(@RequestBody TodoItem todoItem) {
        TodoItem result = todoService.createTodoItem(todoItem);
        if (result == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request. Make sure to fill up TODO properly.");
        return ResponseEntity.ok(result);
    }



}
