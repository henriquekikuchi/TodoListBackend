package br.com.kikuchi.henrique.todolistv3.dto;

import javax.validation.constraints.NotNull;

public record TaskCreateDTO(
        @NotNull(message = "Title cannot be null")
        String title,
        @NotNull(message = "Description cannot be null")
        String description) {
}
