import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTest02 {
        /*
    Given
      Kullanıcı veritabanına bağlanır

    When
      Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını almak üzere sorgu gönderir

    Then
      Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısını doğrular

    And
      Kullanıcı, bağlantıyı kapatır
    */

    @Test
    public void countryTest02() throws SQLException {
        //Kullanıcı veritabanına bağlanır
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpront","password");

        //Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını almak üzere sorgu gönderir
        String query="select country_name from countries where region_id=1";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        //Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısını doğrular
        int count = 0;
        while (rs.next()){
            count++;
        }
        Assert.assertEquals(count,8);

        //Kullanıcı, bağlantıyı kapatır
        st.close();
        con.close();

    }
}
