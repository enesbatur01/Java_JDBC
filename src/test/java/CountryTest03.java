import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given
Kullanıcı veritabanına bağlanır

When
Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını almak üzere sorgu gönderir

Then
Kullanıcı, ülke isimlerini doğrular: "Belgium", "Switzerland", "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom"

And
Kullanıcı, bağlantıyı kapatır
*/
public class CountryTest03 {


    @Test
    public void countrytest03() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpront","password");

        String query="select country_name from countries where region_id=1";
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);
        List<String> name= new ArrayList<>();
        List<String> country= new ArrayList<>(Arrays.asList("Belgium", "Switzerland", "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom"));

        int idx=0;
        while (rs.next()){
            name.add(idx,rs.getString("country_name"));
            idx++;
        }

        Assert.assertEquals(name,country);

        st.close();
        con.close();






    }
}
