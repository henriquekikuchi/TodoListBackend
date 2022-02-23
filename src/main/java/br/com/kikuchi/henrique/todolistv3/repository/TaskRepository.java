package br.com.kikuchi.henrique.todolistv3.repository;

import br.com.kikuchi.henrique.todolistv3.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
