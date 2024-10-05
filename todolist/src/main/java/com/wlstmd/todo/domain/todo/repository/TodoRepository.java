package com.wlstmd.todo.domain.todo.repository;

import com.wlstmd.todo.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
