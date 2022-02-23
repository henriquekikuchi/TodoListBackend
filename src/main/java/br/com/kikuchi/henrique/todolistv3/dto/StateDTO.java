package br.com.kikuchi.henrique.todolistv3.dto;

import javax.validation.constraints.NotNull;

public record StateDTO(
        @NotNull(message="Description cannot be null!")
        String description) {
}
