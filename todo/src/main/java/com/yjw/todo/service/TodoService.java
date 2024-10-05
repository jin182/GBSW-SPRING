package com.yjw.todo.service;

import com.yjw.todo.dto.TodoDto;
import com.yjw.todo.dto.TodoRequest;
import com.yjw.todo.domain.TodoEntity;
import com.yjw.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoConverter todoConverter;

    @Transactional
    public TodoDto create(TodoRequest todoRequest) {
        var entity = TodoEntity.builder()
                .title(todoRequest.getTitle())
                .dueDate(todoRequest.getDueDate())
                .build();
        var savedEntity = todoRepository.save(entity);
        return todoConverter.toDto(savedEntity);
    }

    @Transactional(readOnly = true)
    public List<TodoDto> getAll() {
        return todoRepository.findAll().stream()
                .map(todoConverter::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TodoDto updateDoneStatus(Long id) {
        var entity = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (entity.getDoneAt() == null) {
            entity.setDoneAt(LocalDateTime.now());
        } else {
            entity.setDoneAt(null);
        }

        return todoConverter.toDto(todoRepository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}