package com.wlstmd.todo.domain.todo.service;

import com.wlstmd.todo.domain.todo.dto.AddTodoRequest;
import com.wlstmd.todo.domain.todo.dto.TodoResponse;
import com.wlstmd.todo.domain.todo.entity.Todo;
import com.wlstmd.todo.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<TodoResponse> getTodos() {
        return todoRepository.findAll()
                .stream().map(TodoResponse::new)
                .toList();
    }

    @Transactional
    public TodoResponse addTodo(AddTodoRequest request) {
        Todo saveTodo = todoRepository.save(request.getEntity());
        return new TodoResponse(saveTodo);
    }

    @Transactional
    public void updateTodo(int id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
        todo.setDoneAt(LocalDateTime.now());
        new TodoResponse(todoRepository.save(todo));
    }

    @Transactional
    public void deleteTodo(int id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
        todoRepository.delete(todo);
    }
}