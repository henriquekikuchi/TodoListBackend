package br.com.kikuchi.henrique.todolistv3.dto;

import br.com.kikuchi.henrique.todolistv3.model.Task;

import javax.validation.constraints.NotNull;

public record TaskUpdateDTO (
        @NotNull(message = "Title cannot be null")
        String title,
        @NotNull(message = "Description cannot be null")
        String description
){
}
