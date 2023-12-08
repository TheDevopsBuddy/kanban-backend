package com.board.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.kanban.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
