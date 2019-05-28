package app.converter;

import app.entity.Direction;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class DirectionConverter implements AttributeConverter<Direction, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Direction direction) {
        if (direction == null) {
            return null;
        }
        return direction.getId();
    }

    @Override
    public Direction convertToEntityAttribute(Integer id) {
        return Arrays.stream(Direction.values())
                .filter(a -> a.getId().equals(id)).findFirst().
                        orElse(null);
    }
}
