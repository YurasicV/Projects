package app.repository;

import app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value =
            "select tt.* from tasks tt " +
            "where tt.author_id = :userId " +
            "union all " +
            "select distinct t.* from resolutions r " +
            "left join tasks t on r.task_id = t.id " +
            "where r.user_id = :userId " +
            "order by dt_created ",
            nativeQuery = true)
    List<Task> findAllByResolutionUser(@Param("userId") Long userId);
}
