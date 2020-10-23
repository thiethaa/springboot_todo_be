package com.thiethaa.todolist.service;

import com.thiethaa.todolist.entity.Todo;
import com.thiethaa.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(String id) {
        Optional<Todo> exist = todoRepository.findById(id);
        Todo todo = null;
        if (exist.isPresent()) {
            todo = exist.get();
        }
        return todo;
    }

    @Override
    public Todo add(Todo newTodo) {
        Todo todo = new Todo();
        todo.setTitle(newTodo.getTitle());
        todo.setDate(newTodo.getDate());
        todo.setTime(newTodo.getTime());
        todo.setComplete(false);
        todoRepository.save(todo);
        return todo;
    }

    @Override
    public Todo update(Todo newTodo, String id) {
        Optional<Todo> exist = todoRepository.findById(id);
        Todo todo = null;
        if (exist.isPresent()) {
            todo = exist.get();
            String title = todo.getTitle();
            String date = todo.getDate();
            String time = todo.getTime();

            if (newTodo.getTitle() == null) {
                todo.setTitle(title);
            } else {
                todo.setTitle(newTodo.getTitle());
            }
            if (newTodo.getDate() == null) {
                todo.setDate(date);
            } else {
                todo.setDate(newTodo.getDate());
            }
            if (newTodo.getTime() == null) {
                todo.setTime(time);
            } else {
                todo.setTime(newTodo.getTime());
            }

            todo.setComplete(newTodo.isComplete());

            todoRepository.save(todo);
        }
        return todo;
    }

    @Override
    public void delete(String id) {
        todoRepository.deleteById(id);
    }
}
