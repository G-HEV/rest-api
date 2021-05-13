package pl.ghev.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ghev.restapi.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
