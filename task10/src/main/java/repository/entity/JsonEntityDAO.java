package repository.entity;

import repository.entity.EntityDAO;
import repository.entity.Entity;
import java.util.Map;

public class JsonEntityDAO<T extends Entity> implements EntityDAO<T> {

    @Override
    public T get(int id) {
        return null;
    }

    @Override
    public Map<Integer, T> getAll() {
        return null;
    }

    @Override
    public boolean add(T object) {
        return false;
    }

    @Override
    public boolean update(T object) {
        return false;
    }

    @Override
    public boolean delete(T object) {
        return false;
    }
}
