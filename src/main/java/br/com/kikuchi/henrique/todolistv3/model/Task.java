package br.com.kikuchi.henrique.todolistv3.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
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

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private State state;

    @NotNull
    private Date createdAt = new Date();

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