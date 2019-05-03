package repository.entity;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RamEntityDAO<T extends Entity> implements EntityDAO<T> {
    private Map<Integer, T> objects = new HashMap<>();

    @Override
    public T get(int id) {
        return objects.get(id);
    }

    @Override
    public Map<Integer, T> getAll() {
        return objects;
    }

    @Override
    public boolean add(T object) {
        int id = object.getEntityId();
        if (objects.containsKey(id)) {
            return false;
        }
        T cloned = clone(object);
        if (cloned == null) {
            return false;
        }
        objects.put(id, cloned);
        return true;
    }

    @Override
    public boolean update(T object) {
        int id = object.getEntityId();
        if (!objects.containsKey(id)) {
            return false;
        }
        T cloned = clone(object);
        if (cloned == null) {
            return false;
        }
        objects.put(id, cloned);
        return true;
    }

    @Override
    public boolean delete(T object) {
        int id = object.getEntityId();
        if (objects.containsKey(id)) {
            objects.remove(id);
            return true;
        }
        return false;
    }

    private T clone(T object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(baos);
            ous.writeObject(object);
            ous.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
