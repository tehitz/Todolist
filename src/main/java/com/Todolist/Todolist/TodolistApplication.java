package com.Todolist.Todolist;

import com.Todolist.Todolist.Domain.Todo;
import com.Todolist.Todolist.Domain.User;
import com.Todolist.Todolist.Domain.TodoRepository;
import com.Todolist.Todolist.Domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class TodolistApplication {
	private static final Logger log = LoggerFactory.getLogger(TodolistApplication.class);

	@Autowired
	private TodoRepository TRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner todolist(TodoRepository TRepository, UserRepository uRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				log.info("Creating an Admin user");

				User Admin = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				uRepository.save(Admin);

				log.info("Creating a normal user");
				User user = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");

				DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm");
				Date date = new Date();
				System.out.println(dateFormat.format(date)); //For example 2016/11/16 12:08:43

				log.info("Creating a one todo to show some example data");
				Todo todo1 = new Todo("Do a school project", dateFormat.format(date), "7.12.2018");
				TRepository.save(todo1);

				log.info("Logging all todos");
				for (Todo todo : TRepository.findAll()) {
					log.info(todo.toString());
				}

			}
		};
	}

}