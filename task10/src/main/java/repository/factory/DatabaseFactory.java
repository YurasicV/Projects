package repository.factory;

import repository.database.DatabaseDAO;
import repository.database.JsonDatabaseDAO;
import repository.database.RamDatabaseDAO;

public class DatabaseFactory {
    public static DatabaseDAO getDatabaseDAO(DatabaseType databaseType) {
        switch (databaseType) {
            case RAM:
                return new RamDatabaseDAO();
            case JSON:
                return new JsonDatabaseDAO();
            default:
                return new RamDatabaseDAO();
        }
    }
}
