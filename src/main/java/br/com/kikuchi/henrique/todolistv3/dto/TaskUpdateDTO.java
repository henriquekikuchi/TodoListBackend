package br.com.kikuchi.henrique.todolistv3.dto;

import br.com.kikuchi.henrique.todolistv3.model.Task;

public record TaskUpdateDTO (
        String title,
        String description,
        Task task
){
}
