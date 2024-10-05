package com.yjw.todo.service;

import com.yjw.todo.dto.TodoDto;
import com.yjw.todo.domain.TodoEntity;
import org.springframework.stereotype.Component;

@Component
public class TodoConverter {
    public TodoDto toDto(TodoEntity todoEntity) {
        if (todoEntity == null) {
            return null;
        }
        return TodoDto.builder()
                .id(todoEntity.getId())
                .title(todoEntity.getTitle())
                .dueDate(todoEntity.getDueDate())
                .doneAt(todoEntity.getDoneAt())
                .build();
    }

    public TodoEntity todoEntity(TodoDto todoDto) {
        if (todoDto == null) {
            return null;
        }

        return TodoEntity.builder()
                .id(todoDto.getId())
                .title(todoDto.getTitle())
                .dueDate(todoDto.getDueDate())
                .doneAt(todoDto.getDoneAt())
                .build();
    }

}
