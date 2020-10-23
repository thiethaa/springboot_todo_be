package com.thiethaa.todolist.service;

import com.thiethaa.todolist.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodoList();

    Todo getTodoById(String id);

    Todo add(Todo todo);

    Todo update(Todo todo, String id);

    void delete(String id);


}
