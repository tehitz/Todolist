package com.Todolist.Todolist.Domain;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long>{
    Todo findTodosById(Long id);
}
