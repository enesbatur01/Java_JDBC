import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpront","password");
        Statement st = con.createStatement();

        //ÖRNEK 1:id'si 5 ile 10 arasında olan ülkelerin "country_name" bilgisini listeleyiniz.

        ///kayıtlarımızı görmek için executeQuery() kullanmalıyız.
        ResultSet resultSet =st.executeQuery("SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10");
//        resultSet.next();
//        System.out.println("Ülke ismi = " + resultSet.getString("country_name"));
        while(resultSet.next()){
            System.out.println("Ülke ismi = " + resultSet.getString("country_name"));
//            String name= resultSet.getString("country_name");
//            List<String> names=new ArrayList<>();
//            names.add(resultSet.getString("country_name"));
        }

        //ResultSet'te geriye dönüş yoktur.

        //ÖRNEK 2: phone_code'u 600 den büyük olan ülkelerin "phone_code" ve "country_name" bilgisini listeleyiniz.

        ResultSet rs1=st.executeQuery("SELECT phone_code, country_name FROM countries WHERE phone_code >600");
        while (rs1.next()){
            System.out.println("tel kodu: "+rs1.getInt("phone_code")+" - "+rs1.getString("country_name"));
        }

        //ÖRNEK 3:it_persons tablosunda "salary" değeri en düşük salary olan yazılımcıların tüm bilgilerini gösteriniz.

        ResultSet rs2=st.executeQuery("SELECT * FROM it_persons WHERE salary = (SELECT MIN(salary) FROM it_persons)");

        while (rs2.next()){
            System.out.println(rs2.getInt("id")+"--"+rs2.getString("name")+"--"
                    +rs2.getDouble("salary")+"--"+rs2.getString("prog_lang"));
        }


        //ÖRNEK 4:Puanı bölümlerin taban puanlarının ortalamasından yüksek olan öğrencilerin isim ve puanlarını listeleyiniz.ÖDEVV


        ResultSet rs3= st.executeQuery("SELECT isim,puan FROM ogrenciler WHERE puan> (SELECT AVG(taban_puani) FROM bolumler)");

        while (rs3.next()){
            System.out.println("Isim : "+ rs3.getString("isim")+" Puan : "+ rs3.getInt("puan") );
        }


        st.close();
        con.close();

    }
}
