package repository.entity;

import java.util.Map;

public interface EntityDAO<T extends Entity> {
    T get(int id);
    Map<Integer, T> getAll();
    boolean add(T object);
    boolean update(T object);
    boolean delete(T object);
}
