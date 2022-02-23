package br.com.kikuchi.henrique.todolistv3.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    private Integer id;

    @Getter
    @NotNull(message = "Text cannot be null")
    private String text;

    @Getter
    private Date createdAt;

    @ManyToOne(targetEntity = Task.class, cascade = CascadeType.ALL)
    private Task task;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

}
