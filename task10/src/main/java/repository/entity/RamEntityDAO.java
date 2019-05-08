package repository.entity;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RamEntityDAO<T extends Entity> implements EntityDAO<T> {
    private Map<Class<? extends Entity>, Map<Integer, ? extends Entity>> database;
    private Map<Integer, T> entityTable;
    private Class<T> entityClass;

    public RamEntityDAO(Class<T> entityClass,
                        Map<Class<? extends Entity>, Map<Integer, ? extends Entity>> database) {
        this.database = database;
        this.entityClass = entityClass;

        if (database.containsKey(entityClass)) {
            entityTable = (Map<Integer, T>) database.get(entityClass);
        } else {
            entityTable = new HashMap<>();
            database.put(entityClass, entityTable);
        }
    }

    @Override
    public T get(int id) {
        T entity = clone(entityTable.get(id));
        actualize(entity);
        return entity;
    }

    @Override
    public Map<Integer, T> getAll() {
        Map<Integer, T> map = new HashMap<>();
        entityTable.forEach((k, v) -> map.put(k, get(k)));
        return map;
    }

    @Override
    public boolean add(T object) {
        int id = object.getEntityId();
        if (entityTable.containsKey(id)) {
            return false;
        }
        T cloned = clone(object);
        if (cloned == null) {
            return false;
        }
        entityTable.put(id, cloned);
        return true;
    }

    @Override
    public boolean update(T object) {
        int id = object.getEntityId();
        if (!entityTable.containsKey(id)) {
            return false;
        }
        T cloned = clone(object);
        if (cloned == null) {
            return false;
        }
        entityTable.put(id, cloned);
        return true;
    }

    @Override
    public boolean delete(T object) {
        int id = object.getEntityId();
        if (entityTable.containsKey(id)) {
            entityTable.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "----" + entityClass.getName() + "----\n" +
                entityTable.keySet().stream().map(k -> get(k).toString())
                        .collect(Collectors.joining("\n")) +
                "\n----------------------\n";
    }

    private T clone(T object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(baos);
            ous.writeObject(object);
            ous.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void actualize(Entity entity) {
        if (entity == null) {
            return;
        }
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object fieldObject = field.get(entity);
                if (fieldObject instanceof Entity) {
                    Entity fieldEntity = (Entity) fieldObject;
                    Class fieldType = field.getType();
                    if (database.containsKey(fieldType)) {
                        Map<Integer, ? extends Entity> table = database.get(fieldType);
                        int id = fieldEntity.getEntityId();
                        if (table.containsKey(id)) {
                            Entity correctFieldEntity = table.get(id);
                            field.set(entity, correctFieldEntity);
                        }
                    }
                    actualize(fieldEntity);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
