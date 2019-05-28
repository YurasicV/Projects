package app.converter;

import app.entity.Result;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class ResultConverter implements AttributeConverter<Result, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Result result) {
        if (result == null) {
            return null;
        }
        return result.getId();
    }

    @Override
    public Result convertToEntityAttribute(Integer id) {
        return Arrays.stream(Result.values())
                .filter(a -> a.getId().equals(id)).findFirst().
                        orElse(null);
    }
}
