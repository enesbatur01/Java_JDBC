import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTestOdev01 {

    /*
 Given
   Kullanıcı veritabanına bağlanır

 When
   Kullanıcı, 'countries' table'dan region id'leri almak üzere query gönderir

 Then
   Kullanıcı, 1'den büyük region id'lerin sayısının 17 olduğunu doğrula

 And
   Kullanıcı, bağlantıyı kapatır
 */

    @Test
    public void countryTest() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpront","password");

        String query="select region_id from countries where region_id > 1";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        int count = 0;
        while (rs.next()){
            count++;
        }
        Assert.assertEquals(count,17);




    }
}
