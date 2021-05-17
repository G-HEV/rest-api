package pl.ghev.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ghev.restapi.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
