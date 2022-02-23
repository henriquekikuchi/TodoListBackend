package br.com.kikuchi.henrique.todolistv3.repository;

import br.com.kikuchi.henrique.todolistv3.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Optional<List<Comment>> findAllByTaskId(Integer taskId);
    Optional<Comment> findByIdAndTaskId(Integer id, Integer taskId);
    @Transactional
    @Modifying
    void deleteByIdAndTaskId(Integer id, Integer taskId);
}
