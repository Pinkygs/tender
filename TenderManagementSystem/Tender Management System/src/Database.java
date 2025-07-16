
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pinky gupta
 */
public class Database {
    String jdbcDriver = "";
    String dbURL = "";
    String username = "";
    String password = "";
    
    Connection connection;
    private String Query;
    
    //load the Driver(Class.forName(jdbce
    //close the connenction (connection.close();)
    public Database() throws SQLException, ClassNotFoundException{
        jdbcDriver = "com.mysql.jdbc.Driver";
        // jdbcDrivar ="oracle.jdbc.driver.OracleDriver";
        dbURL = "jdbc:mysql://localhost:3306/tender";
        //dbURL = " jdbc:oracle:thin:@//server.local:152"
        username ="root";
        password ="root";
        
        //1.load the driver(Class.forName(jdbcDriver));
        Class.forName(jdbcDriver);//set java database connectivitly driver
        //2.get the connection
        connection = DriverManager.getConnection(dbURL, username, password);
    }
    //3.prepare the statement or query
    public ResultSet executeQuery(String query)throws SQLException
    {
        PreparedStatement st = connection.prepareStatement(query);
        return st.executeQuery();
    }
    public int executUpdate(String Statement) throws SQLException
            {
             PreparedStatement st = connection.prepareStatement(Statement);
                return st.executeUpdate();   
                
            }
    //4.close the connection
    public void close()
    {
        try
        {
            connection.close();
        }
        catch(SQLException sqlException)
        {
            
        }
    }
    protected void finalize()
    {
        close();
    }
    
}
