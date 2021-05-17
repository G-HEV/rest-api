package pl.ghev.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ghev.restapi.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
