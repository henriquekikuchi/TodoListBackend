package br.com.kikuchi.henrique.todolistv3.dto;

import javax.validation.constraints.NotNull;

public record CommentCreateDTO(
        @NotNull(message = "Text cannot be null")
        String text
) {
}
