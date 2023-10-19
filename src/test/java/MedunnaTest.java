import org.junit.Assert;
import org.junit.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import static utils.JdbcMedunnaDBUtils.*;

/*
   Given
     Kullanıcı veritabanına bağlanır
     (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6))

   When
     Kullanıcı, oluşturulan odayı getirmek için room_number ile sorgu gönderir

   Then
     Kullanıcı, oda bilgilerinin doğru kaydedildiğini doğrular

   And
     Kullanıcı, bağlantıyı kapatır
  */



public class MedunnaTest {
    @Test
    public void MedunnaTest() throws SQLException {
        //Expected Datalar
        int expectedRoomNumber = 654654654;
        String expectedRoomType = "PREMIUM_DELUXE";
        boolean expectedStatus=true;
        double expectedPrice=1.00;
        String expectedDescription="Enes Çıtır's Room";

        String query="Select * from room where room_number= 654654654";
        ResultSet rs=executeQuery(query);
        rs.next();

        int actualRoomNumber = rs.getInt("room_number");
        String actualRoomType=rs.getString("room_type");
        boolean actualStatus=rs.getBoolean("status");
        double actualPrice= rs.getDouble("price");
        String actualDescription = rs.getString("description");

        Assert.assertEquals(expectedRoomNumber,actualRoomNumber);
        Assert.assertEquals(expectedRoomType,actualRoomType);
        Assert.assertEquals(expectedStatus,actualStatus);
        Assert.assertEquals(expectedPrice,actualPrice,0.01);
        Assert.assertEquals(expectedDescription,actualDescription);



        closeConnection();


    }
}
