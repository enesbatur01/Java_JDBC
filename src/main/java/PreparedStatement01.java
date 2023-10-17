import java.sql.*;

/*
PreparedStatement; önceden derlenmiş tekrar tekrar kullanılabilen parametreli sorgular
oluşturmamızı ve çalıştırmamızı sağlar.

PreparedStatement Statement ı extend eder(Statementın gelişmiş halidir.)

 */

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpront","password");
        Statement st =con.createStatement();

        //ÖRNEK1:bolumler tablosunda Matematik bölümünün taban_puani'nı 475 olarak güncelleyiniz.
        //String query="UPDATE bolumler SET taban_puani=475 WHERE bolum ILIKE 'matematik'";
        //st.executeUpdate(query);

        //parametreli bir sorguyu string oalrak yazalım
        String query = "UPDATE bolumler SET taban_puani= ? WHERE bolum ILIKE ?";

        //parametreli sorguyu oluşturalım
        PreparedStatement prst = con.prepareStatement(query);

        //parametreleri set edelim
        prst.setInt(1,475);
        prst.setString(2,"matematik");

        //parametrelerini verdiğimiz sorguyu artık çalıştıralım
        int updated=prst.executeUpdate();
        System.out.println("updated = " + updated);

        System.out.println("------------------------------------------");

        //ÖRNEK2:(Prepared Statement kullanarak) bolumler tablosunda Edebiyat bölümünün taban_puanı'nı 455 olarak güncelleyiniz.

        prst.setInt(1,455);
        prst.setString(2,"edebiyat");

        int updated2= prst.executeUpdate();

        System.out.println("updated2 = " + updated2);

        System.out.println("------------------------------------------");

        //ÖRNEK3:Prepared Statement kullanarak ogrenciler tablosundan Matematik bölümünde okuyanları siliniz.

        String query3="DELETE FROM ogrenciler WHERE bolum ILIKE ?";
        PreparedStatement prst2= con.prepareStatement(query3);

        prst2.setString(1,"matematik");
        int updated3= prst2.executeUpdate();

        System.out.println("updated3 = " + updated3);

        //ÖRNEK4:Prepared Statement kullanarak bolumler tablosuna
        // Yazılım Mühendisliği(id=5006,taban_puanı=475, kampus='Merkez') bölümünü ekleyiniz.

        System.out.println("------------------------------------------");


        String query4="INSERT INTO bolumler VALUES(?,?,?,?)";

        PreparedStatement prst3= con.prepareStatement(query4);

        prst3.setInt(1,5006);//(id,bolum,taban_puani,kampus)
        prst3.setString(2,"Yazılım Müh.");
        prst3.setInt(3,475);
        prst3.setString(4,"Merkez");

        int updated4= prst3.executeUpdate();

        System.out.println("updated4 = " + updated4);


        prst.close();
        st.close();
        con.close();


    }
}
