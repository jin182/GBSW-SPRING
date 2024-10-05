package com.wlstmd.todo.domain.todo.dto;

import com.wlstmd.todo.domain.todo.entity.Todo;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddTodoRequest {
    @NotEmpty(message = "할 일은 필수입니다.")
    @Size(max = 100)
    private String title;
    @NotEmpty(message = "마감일 은 필수 입니다.")
    private String dueDate;

    public Todo getEntity() {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDueDate(LocalDateTime.parse(dueDate));
        return todo;
    }
}