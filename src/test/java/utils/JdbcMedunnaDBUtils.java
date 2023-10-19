package utils;

import java.sql.*;

public class JdbcMedunnaDBUtils {
   static Connection con;
   static Statement st=null;
    public static Connection connectJDBC () {

        try {
          con = DriverManager.getConnection
                   ("jdbc:postgresql://medunna.com:5432/medunna_db_v2","select_user","Medunna_pass_@6");
       }catch (SQLException e){
           throw new RuntimeException(e);
       }
       return con;
    }

    public static Statement createStatement(){


        try {
            st=connectJDBC().createStatement();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return st;
    }


    public static ResultSet executeQuery(String query){

        ResultSet resultSet = null;
        try {
            resultSet = createStatement().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public static void closeConnection()  {
        try {
            con.close();
            st.close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }


    }







}
