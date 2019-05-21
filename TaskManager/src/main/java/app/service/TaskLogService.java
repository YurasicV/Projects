package app.service;

import app.repository.TaskLogRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskLogService {
    private TaskLogRepository taskLogRepository;

    public TaskLogService(TaskLogRepository taskLogRepositoryRepository) {
        this.taskLogRepository = taskLogRepositoryRepository;
    }

    public Object findAllByTaskId(Long id) {
        return taskLogRepository.findAllByTaskId(id);
    }
}
