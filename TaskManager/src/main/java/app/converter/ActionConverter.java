package app.converter;

import app.entity.Action;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class ActionConverter implements AttributeConverter<Action, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Action action) {
        if (action == null) {
            return null;
        }
        return action.getId();
    }

    @Override
    public Action convertToEntityAttribute(Integer id) {
        return Arrays.stream(Action.values())
                .filter(a -> a.getId().equals(id)).findFirst().
                        orElse(null);
    }
}
