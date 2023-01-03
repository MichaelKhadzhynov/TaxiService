package com.solvd.TaxiService.Taxi;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final ConnectionPool INSTANCE = new ConnectionPool();

    private final String dataBaseUrl = "jdbc:mysql://localhost:3306/myDB";
    private final String userName  = "root";
    private final String password = "12345678";



    private final int maxPoolSize = 5;
    private int connectionNumber = 0;

    private static final String SQL_VERIFICATION = "select_1";

    Stack<Connection> freePool = new Stack<>();
    Set<Connection> occupiedPool = new HashSet<>();

    private ConnectionPool() {
    }

    public synchronized Connection getConnection() throws SQLException {
        Connection conn = null;
        if (isFull()) {
            throw new SQLException("Connection pool is full");
        }
        conn = getConnectionFromPool() ;
        if (conn == null) {
            conn = createNewConnectionForPool();
        }

        conn = makeAvailable(conn);
        LOGGER.info("Connection number - " + connectionNumber + " | " + " Thread ID - " + " " + Thread.currentThread().getId());

        return conn;
    }

    public synchronized void releaseConnection(Connection conn) throws SQLException {
        if (conn == null) {
            throw new NullPointerException();
        }

        if (!occupiedPool.remove(conn)) {
            throw new SQLException("Connection is returned already or it isn't for this pool");
        }

        freePool.push(conn);
    }

    private synchronized boolean isFull() {

        return ((freePool.size() == 0) && (connectionNumber >= maxPoolSize));
    }

    private Connection createNewConnectionForPool() throws SQLException {
        Connection conn = createNewConnection();
        connectionNumber++;
        occupiedPool.add(conn);
        return conn;
    }

    private Connection createNewConnection() throws SQLException {
        return DriverManager.getConnection(dataBaseUrl, userName, password);
    }

    private Connection getConnectionFromPool()  {
        Connection conn = null;
        if (freePool.size() > 0) {
            conn = freePool.pop();
            occupiedPool.add(conn);
        }
        return conn;
    }

    private Connection makeAvailable(Connection conn) throws SQLException{
        if (isConnectionAvailable(conn)){
            return conn;
        }
        occupiedPool.remove(conn);
        connectionNumber--;
        conn.close();

        conn = createNewConnection();
        occupiedPool.add(conn);
        connectionNumber++;
        return conn;
    }

    private boolean isConnectionAvailable(Connection conn){
        try (Statement st = conn.createStatement()) {
            st.executeQuery(SQL_VERIFICATION);
            return  true;
        } catch (SQLException e){
            return false;
        }
    }


    public static ConnectionPool getInstance() {
        return ConnectionPool.INSTANCE;
    }
}
