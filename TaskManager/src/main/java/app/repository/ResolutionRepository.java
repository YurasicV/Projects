package app.repository;

import app.entity.Resolution;
import app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ResolutionRepository extends JpaRepository<Resolution, Long> {
    public Set<Resolution> findAllByTask(Task task);
}
