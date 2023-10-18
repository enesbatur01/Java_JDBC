import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTest01 {

        /*
    Given = Hazırlık işlemleri
      Kullanıcı veritabanına bağlanır

    When = Eylem ile ilgili işlemler
      Kullanıcı, 'countries' tablosundan ülke adlarını almak üzere sorgu gönderir

    Then = assertion(doğrulamalar) işlemlerinde kullanılır
      Kullanıcı, country_name sütununda en az bir ülke adı olduğunu doğrular

    And = Kendisinden önceki anahtar kelimenin devamını ifade etmek için kullanılır
      Kullanıcı, Bağlantıyı kapatır
    */

    @Test
    public void  countryTest () throws SQLException {

        // Kullanıcı veritabanına bağlanır
       Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpront","password");

       //Kullanıcı, country_name sütununda en az bir ülke adı olduğunu doğrular
        String query="SELECT country_name FROM countries ";
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(query);
        int count=0;
        while (rs.next()){
            count++;
        }

        //Kullanıcı, country_name sütununda en az bir ülke adı olduğunu doğrular
        Assert.assertTrue(count>0);

        //Kullanıcı, Bağlantıyı kapatır
        st.close();
        con.close();



    }







}
