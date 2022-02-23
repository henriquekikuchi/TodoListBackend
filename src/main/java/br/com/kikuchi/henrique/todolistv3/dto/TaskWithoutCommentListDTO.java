package br.com.kikuchi.henrique.todolistv3.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public class TaskWithoutCommentListDTO{

    private Integer id;
    private String title;
    private String description;
    private String state;
    private Date createdAt;
    private Date updatedAt;
}
