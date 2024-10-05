package com.yjw.todo.controller;

import com.yjw.todo.dto.TodoDto;
import com.yjw.todo.dto.TodoRequest;
import com.yjw.todo.service.TodoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoRequest request) {
        return ResponseEntity.ok(todoService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAll());
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<TodoDto> toggleTodoStatus(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.updateDoneStatus(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.ok().build();
    }
}