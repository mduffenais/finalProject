/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fposs.database;

import java.sql.SQLException;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author hirev
 */
public class DbUtil {
    protected static String userName;
    protected static String password;
    
    public DbUtil(String user, String Password) throws SQLException {
        DbUtil.userName=user;
        DbUtil.password=Password;
        logIn();
    }
        public static void logIn() throws SQLException {
            try{
        Connection conn = DbConnect.Connect();
        Statement stmt = conn.createStatement();
        String sql = "Select * from users where username='"+userName+ "' and password ='"+password+"'"; 
        ResultSet rs = stmt.executeQuery(sql);
        if ( rs.next() ) {
            System.out.println("This is a log in");
    }
        else{
        System.out.println("Nope didnt work");
        }
        
        }
        catch(SQLException e){}
        

        }
    
}
