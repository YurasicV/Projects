package repository.database;

import repository.entity.Entity;
import repository.entity.EntityDAO;
import repository.entity.RamEntityDAO;

public class RamDatabaseDAO implements DatabaseDAO {

    @Override
    public <T extends Entity> EntityDAO<T> getEntityDAO() {
        return new RamEntityDAO<T>();
    }
}
