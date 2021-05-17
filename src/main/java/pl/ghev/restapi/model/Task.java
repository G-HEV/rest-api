package pl.ghev.restapi.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CREATED")
    private LocalDate created;

    @Column(name = "IS_DONE")
    private Boolean isDone;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Project project;

    public Task(String content, Boolean isDone, Project project) {
        this.content = content;
        this.isDone = isDone;
        this.project = project;
        this.created = LocalDate.now();
    }
}
