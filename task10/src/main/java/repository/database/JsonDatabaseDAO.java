package repository.database;

import repository.entity.Entity;
import repository.entity.EntityDAO;
import repository.entity.JsonEntityDAO;

public class JsonDatabaseDAO implements DatabaseDAO {

    @Override
    public <T extends Entity> EntityDAO<T> getEntityDAO(Class<T> entityClass) {
        return new JsonEntityDAO<T>();
    }
}
