package br.com.kikuchi.henrique.todolistv3.repository;

import br.com.kikuchi.henrique.todolistv3.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    public Optional<List<Comment>> findAllByTaskId(Integer taskId);
    public Optional<Comment> findByIdAndTaskId(Integer id, Integer taskId);
    public void deleteByIdAndTaskId(Integer id, Integer taskId);
}
