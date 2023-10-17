import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction02 {
    public static void main(String[] args) throws SQLException {
        //DOĞRU YAKLAŞIM !!!! : bir birine bağımlı olan bu iki işlemi
        //tek bir transaction içine almak

        //hesap no:1234 ten hesap no:5678 e 1000$ para transferi olsun.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpront","password");

        //transaction yönetimini alalım
        con.setAutoCommit(false);
        PreparedStatement prst=null;


        try{
            String sql="UPDATE hesaplar SET bakiye=bakiye+? WHERE hesap_no=?";
            prst =con.prepareStatement(sql);

            //1-para transferi yapan
            prst.setInt(1,-1000);
            prst.setInt(2,1234);
            prst.executeUpdate(); //commit edilene kadar değişiklik kalıcı hale gelmez

            if (false){
                throw new Exception();
            }

            //2-para transferi alan
            prst.setInt(1,1000);
            prst.setInt(2,5678);
            prst.executeUpdate();

            con.commit();


        }catch (Exception e){
            con.rollback();
            System.out.println("Işlem başarısız");

        }finally {
            prst.close();
            con.close();
        }















    }
}
