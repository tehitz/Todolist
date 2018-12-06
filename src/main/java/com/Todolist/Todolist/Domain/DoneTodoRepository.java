package com.Todolist.Todolist.Domain;

import org.springframework.data.repository.CrudRepository;

public interface DoneTodoRepository extends CrudRepository <DoneTodo, Long>{
    Todo findDoneTodosById(Long id);
}
