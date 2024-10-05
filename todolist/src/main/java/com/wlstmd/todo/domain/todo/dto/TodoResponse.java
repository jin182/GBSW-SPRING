package com.wlstmd.todo.domain.todo.dto;

import com.wlstmd.todo.domain.todo.entity.Todo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoResponse {
    private Integer id;
    private String title;
    private LocalDateTime dueDate;
    private LocalDateTime doneAt;

    public TodoResponse(Todo todo) {
        id = todo.getId();
        title = todo.getTitle();
        dueDate = todo.getDueDate();
        doneAt = todo.getDoneAt();
    }
}