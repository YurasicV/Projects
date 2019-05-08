package repository.database;

import repository.entity.Entity;
import repository.entity.EntityDAO;
import repository.entity.RamEntityDAO;

import java.util.HashMap;
import java.util.Map;

public class RamDatabaseDAO implements DatabaseDAO {
    private Map<Class<? extends Entity>, Map<Integer, ? extends Entity>> database;

    public RamDatabaseDAO() {
        database = new HashMap<>();
    }

    @Override
    public <T extends Entity> EntityDAO<T> getEntityDAO(Class<T> entityClass) {
        return new RamEntityDAO<T>(entityClass, database);
    }
}
