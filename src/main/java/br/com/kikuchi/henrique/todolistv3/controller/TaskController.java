package br.com.kikuchi.henrique.todolistv3.controller;

import br.com.kikuchi.henrique.todolistv3.dto.CommentCreateDTO;
import br.com.kikuchi.henrique.todolistv3.dto.StateDTO;
import br.com.kikuchi.henrique.todolistv3.dto.TaskCreateDTO;
import br.com.kikuchi.henrique.todolistv3.dto.TaskUpdateDTO;
import br.com.kikuchi.henrique.todolistv3.model.Comment;
import br.com.kikuchi.henrique.todolistv3.model.Task;
import br.com.kikuchi.henrique.todolistv3.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/tasks")
public class TaskController {

    private final TaskService taskService;

    /*
    Rotas das tarefas
     */

    @GetMapping
    private ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = this.taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Task> createNewTask(@RequestBody @Valid TaskCreateDTO taskCreateDTO){
        Task newTask = this.taskService.createNewTask(taskCreateDTO);
        return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id){
        Task task = this.taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<String> updateById(
            @PathVariable("id") Integer id,
            @RequestBody @Valid TaskUpdateDTO taskUpdateDTO){
        this.taskService.updateById(id, taskUpdateDTO);
        return new ResponseEntity("updated with successfully", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        this.taskService.deleteById(id);
        return new ResponseEntity("deleted with successfully", HttpStatus.OK);
    }

    @PatchMapping("/{id}/state")
    private ResponseEntity updateStateById(@PathVariable("id") Integer id, @RequestBody @Valid StateDTO state){
        this.taskService.updateStateById(id, state);
        return ResponseEntity.ok(null);
    }

    /*
    Rotas dos comentarios
     */
    @GetMapping("/{id}/comments")
    private ResponseEntity<List<Comment>> getCommentsByTaskId(@PathVariable("id") Integer id){
        List<Comment> commentList = this.taskService.getCommentsByTaskId(id);
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @PostMapping("{id}/comments")
    private ResponseEntity<String> createNewCommentByTaskId(
            @PathVariable("id") Integer id,
            @RequestBody @Valid CommentCreateDTO comment){
        this.taskService.createNewCommentByTaskId(id, comment);
        return new ResponseEntity("Comment has been added with successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}/comments/{id}")
    private ResponseEntity<Comment> getCommentByIdAndTaskId(
            @PathVariable("taskId") Integer taskId,
            @PathVariable("id") Integer id){
        Comment comment = this.taskService.getCommentByIdAndTaskId(id, taskId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}/comments/{id}")
    private ResponseEntity<String> deleteCommentByIdAndTaskId(
            @PathVariable("taskId") Integer taskId,
            @PathVariable("id") Integer id){
        this.taskService.deleteCommentByIdAndTaskId(id, taskId);
        return new ResponseEntity<>("Comment has been deleted with successfuly", HttpStatus.OK);
    }
}
