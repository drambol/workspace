package utility.database;

import java.sql.Connection;

/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose call back method with DB connection
 */
public interface SqlCallback<T> {

    T exec(Connection conn) throws Exception;
}
