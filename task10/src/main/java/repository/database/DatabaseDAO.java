package repository.database;

import repository.entity.Entity;
import repository.entity.EntityDAO;

public interface DatabaseDAO {
    <T extends Entity> EntityDAO<T> getEntityDAO();
}
