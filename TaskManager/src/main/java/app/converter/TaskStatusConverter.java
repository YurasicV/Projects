package app.converter;

import app.entity.TaskStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class TaskStatusConverter implements AttributeConverter<TaskStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TaskStatus taskStatus) {
        if (taskStatus == null) {
            return null;
        }
        return taskStatus.getId();
    }

    @Override
    public TaskStatus convertToEntityAttribute(Integer id) {
        return Arrays.stream(TaskStatus.values())
                .filter(a -> a.getId().equals(id)).findFirst().
                        orElse(null);
    }
}
