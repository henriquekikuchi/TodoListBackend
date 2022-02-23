package br.com.kikuchi.henrique.todolistv3.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    @Getter
    private Integer id;

    @Getter
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
