package pl.ghev.restapi.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import pl.ghev.restapi.repo.PersonRepository;

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
    @JsonIgnore
    private Project project;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
    @JoinColumn(name = "ID_PERSON")
    private Person person;

    public Task(String content, Project project,Person person) {
        this.content = content;
        this.isDone = false;
        this.project = project;
        this.created = LocalDate.now();
        this.person = person;
    }

}
