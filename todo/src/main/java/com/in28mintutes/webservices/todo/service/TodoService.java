package com.in28mintutes.webservices.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in28mintutes.webservices.todo.entity.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList();

	static int idCount = 0;

	static {
		todos.add(new Todo(++idCount, "Rehman", "Learn to Angular", new Date(), false));
		todos.add(new Todo(++idCount, "Rehman", "Learn to SpringBoot", new Date(), true));
		todos.add(new Todo(++idCount, "Rehman", "Learn to SQL", new Date(), false));
		todos.add(new Todo(++idCount, "Rehman", "Learn to MicroServices", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo findById(Long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}

		return null;
	}

	public Todo deleteById(Long Id) {
		Todo todo = findById(Id);
		if (todo != null) {
			todos.remove(todo);
			return todo;
		} else {
			return null;
		}
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCount);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

}
