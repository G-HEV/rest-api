package pl.ghev.restapi.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@EqualsAndHashCode
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;

    @OneToMany(mappedBy = "manager")
    @JsonIgnore
    private List<Project> ownerProjectList;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "PER_PROJ",joinColumns = {@JoinColumn(name = "id_person")},
    inverseJoinColumns = {@JoinColumn(name = "id_project")})
    @JsonIgnore
    private List<Project> projectList;


    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
