package app.repository;

import app.entity.Task;
import app.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value =
            "select distinct t from Task t " +
                    "left join t.resolutions r " +
                    "where t.author = :user " +
                    "or " +
                    "r.user = :user " +
                    "order by t.dtCreated")
    Page<Task> findAllByResolutionUser(@Param("user") User user, Pageable pageable);
}
