package pl.ghev.restapi.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="Project")
@NoArgsConstructor
@EqualsAndHashCode
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROJECT")
    private long idProject;

    private String name;

    @Setter(AccessLevel.NONE)
    private LocalDate created;

    @Column(name = "IS_DONE")
    private Boolean isDone = false;

    @ManyToOne(optional = false,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Person manager;

    @ManyToMany(mappedBy = "projectList")
    @JsonIgnore
    private Set<Person> personList;


    @OneToMany(mappedBy = "project", cascade = {CascadeType.REMOVE,CascadeType.DETACH})
    private Set<Task> taskList;


    public Project(String name,Person manager) {
        this.name = name;
        this.manager = manager;
        this.created = LocalDate.now();
    }
}
