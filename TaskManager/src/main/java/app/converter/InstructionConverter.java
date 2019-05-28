package app.converter;

import app.entity.Instruction;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class InstructionConverter implements AttributeConverter<Instruction, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Instruction instruction) {
        if (instruction == null) {
            return null;
        }
        return instruction.getId();
    }

    @Override
    public Instruction convertToEntityAttribute(Integer id) {
        return Arrays.stream(Instruction.values())
                .filter(a -> a.getId().equals(id)).findFirst().
                        orElse(null);
    }
}
