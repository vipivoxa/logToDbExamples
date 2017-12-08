package com.dummy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnection;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;


public class DummyJava3ConnFak  {

    private final DataSource dataSource;
    private final static String USR="db_usr";
    private final static String PWD="db_pwd";
    private final static String DB_CONN_STR="jdbc:oracle:thin:@//db_host:db_port/db_service_name";
    
	
    private static interface Singleton {
        final DummyJava3ConnFak  INSTANCE = new DummyJava3ConnFak ();
    }
    
    private DummyJava3ConnFak () {
    	DataSource lDataSource=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
       	    System.out.println("Error in getting OracleDriver driver - make sure ojdbc jar is in a Classpath!");
            e.printStackTrace();
            System.exit(0);
        }

        try
        {
	        Properties properties = new Properties();
	        properties.setProperty("user", USR);
	        properties.setProperty("password", PWD);

	        GenericObjectPool pool = new GenericObjectPool();
	        DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
	        		DB_CONN_STR, properties
	        );

	        new PoolableConnectionFactory(connectionFactory, pool, null, "SELECT 1", 3, false, false, Connection.TRANSACTION_READ_COMMITTED);
	        System.out.println("set connection.");
	        
	        lDataSource = new PoolingDataSource(pool);
        }
        catch (Exception ex)
        {
        	ex.printStackTrace();
        }
        finally {
        	this.dataSource = lDataSource;
        }
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }
}