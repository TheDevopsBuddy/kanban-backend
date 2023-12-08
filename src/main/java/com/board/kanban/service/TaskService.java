package com.board.kanban.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.kanban.model.Task;
import com.board.kanban.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	public Optional<Task> getTaskById(Long id) {
		return taskRepository.findById(id);
	}
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task updateTask(Long id, Task updatedTask) {
		if(taskRepository.existsById(id)) {
			updatedTask.setId(id);
			return taskRepository.save(updatedTask);
		}
		return null;
	}
	
//	public boolean deleteTask(Long id) {
//		Optional<Task> taskOptional = taskRepository.findById(id);
//		
//		if (taskOptional.isPresent()) {
//			Task task = taskOptional.get();
//			task.setDeleted(true);
//			taskRepository.save(task);
//			return true;
//		}
//		return false;
//	}
	public boolean deleteTask(Long id) {
		if(taskRepository.existsById(id)) {
			taskRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
