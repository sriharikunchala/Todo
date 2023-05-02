package com.projectstuff.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 0;
	static {
		todos.add(new Todo(++todoCount, "srihari", "Learn Python 1", LocalDate.now().plusYears(1), false));

		todos.add(new Todo(++todoCount, "srihari", "learn java 1", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todoCount, "srihari", "learn c 1 ", LocalDate.now().plusYears(3), false));
		todos.add(new Todo(++todoCount, "kunchala", "learn cpp 1", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);

		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todoCount, username, description, targetDate, done);
		todos.add(todo);
	}

	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findByid(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();

		return todo;

	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		// TODO Auto-generated method stub

	}

}
