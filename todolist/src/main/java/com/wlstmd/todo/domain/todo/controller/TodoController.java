package com.wlstmd.todo.domain.todo.controller;

import com.wlstmd.todo.domain.todo.dto.AddTodoRequest;
import com.wlstmd.todo.domain.todo.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.validation.BindingResult.MODEL_KEY_PREFIX;


@RequiredArgsConstructor
@Controller
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public String getIndex(Model model) {
        if(!model.containsAttribute("addTodoRequest")) {
            model.addAttribute("addTodoRequest", new AddTodoRequest());
        }
        model.addAttribute("todos", todoService.getTodos());
        return "index";
    }

    @PostMapping("/todos")
    public String addTodo(@Valid @ModelAttribute AddTodoRequest addTodoRequest, BindingResult result, Model model, RedirectAttributes attr) {
        if (result.hasErrors()) {
            attr.addFlashAttribute(MODEL_KEY_PREFIX + "addTodoRequest", result);
            attr.addFlashAttribute("addTodoRequest", addTodoRequest);
            return "redirect:/";
        }
        todoService.addTodo(addTodoRequest);
        return "redirect:/";
    }

    @PostMapping("/todos/{id}")
    public String updateTodo(@PathVariable(name = "id") int id) {
        todoService.updateTodo(id);
        return "redirect:/";
    }

    @PostMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable(name = "id") int id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }
}