package br.com.kikuchi.henrique.todolistv3.model;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Description cannot be null")
    private String description;

    @NotNull(message = "State cannot be null")
    private State state;

    @CreatedDate
    private Date createdAt = new Date();

    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "task", cascade={CascadeType.ALL})
    private List<Comment> commentList;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

    @PreUpdate
    void updatedAt(){
        this.updatedAt = new Date();
    }
}