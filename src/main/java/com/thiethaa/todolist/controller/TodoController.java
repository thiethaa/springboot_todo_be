package com.thiethaa.todolist.controller;

import com.thiethaa.todolist.entity.Todo;
import com.thiethaa.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todolist")
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable("id") String id) {
        return todoService.getTodoById(id);
    }

    @PostMapping("/add")
    public Todo add(@RequestBody Todo todo) {
        return todoService.add(todo);
    }

    @PutMapping("/update/{id}")
    public Todo update(@RequestBody Todo todo,@PathVariable("id") String id) {
        return todoService.update(todo, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        todoService.delete(id);
    }
}
