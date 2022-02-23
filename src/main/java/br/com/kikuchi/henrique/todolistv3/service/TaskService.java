package br.com.kikuchi.henrique.todolistv3.service;

import br.com.kikuchi.henrique.todolistv3.dto.*;
import br.com.kikuchi.henrique.todolistv3.exception.BadRequestException;
import br.com.kikuchi.henrique.todolistv3.model.Comment;
import br.com.kikuchi.henrique.todolistv3.model.State;
import br.com.kikuchi.henrique.todolistv3.model.Task;
import br.com.kikuchi.henrique.todolistv3.repository.CommentRepository;
import br.com.kikuchi.henrique.todolistv3.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;

    public Task createNewTask(TaskCreateDTO taskCreateDTO){
        Task newTask = Task.builder()
                .title(taskCreateDTO.title())
                .description(taskCreateDTO.description())
                .state(State.CREATED)
                .build();

        return taskRepository.save(newTask);
    }

    public Task getTaskById(Integer id){
        return this.taskRepository.findById(id).orElseThrow(() ->new BadRequestException("Task not be found!"));
    }

    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }


    public void updateStateById(Integer id, StateDTO state) {
        Task task = this.taskRepository.findById(id).orElse(null);
        if (task != null){
            State stateNew = State.valueOf(state.description());
            task.setState(stateNew);
            this.taskRepository.save(task);
        }
    }

    public void deleteById(Integer id) {
        this.taskRepository.deleteById(id);
    }

    public void updateById(Integer id, TaskUpdateDTO taskUpdateDTO) {
        Task taskToUpdate = this.taskRepository.findById(id).orElseThrow(() ->new BadRequestException("Task not be found!"));
        if (taskToUpdate != null){
            taskToUpdate.setTitle(taskUpdateDTO.title());
            taskToUpdate.setDescription(taskUpdateDTO.description());
            this.taskRepository.save(taskToUpdate);
        }
    }

    public List<Comment> getCommentsByTaskId(Integer id) {
        return this.commentRepository.findAllByTaskId(id).orElseThrow(() ->new BadRequestException("Comment not be found!"));
    }

    public void createNewCommentByTaskId(Integer id, CommentCreateDTO comment) {
        Task task = this.taskRepository.findById(id).orElseThrow(() ->new BadRequestException("Task not be found!"));
        if (task != null){
            Comment commentToAdd = Comment.builder()
                    .text(comment.text())
                    .task(task)
                    .build();
            this.commentRepository.save(commentToAdd);
        }
    }

    public Comment getCommentByIdAndTaskId(Integer id, Integer taskId){
        return this.commentRepository.findByIdAndTaskId(id, taskId).orElse(null);
    }

    public void deleteCommentByIdAndTaskId(Integer id, Integer taskId) {
        this.commentRepository.deleteByIdAndTaskId(id, taskId);
    }
}
