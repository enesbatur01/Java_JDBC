import org.junit.Assert;
import org.junit.Test;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.JdbcLocalDBUtils.*;

public class CountryTestOdev02 {
    @Test
    public void countryTest() throws SQLException {

        String query="select region_id from countries where region_id >1 ";

        ResultSet rs = executeQuery(query);
        int count=0;
        while (rs.next()){
            count++;

        }
        Assert.assertEquals(count,17);

        closeConnection();

    }
}
