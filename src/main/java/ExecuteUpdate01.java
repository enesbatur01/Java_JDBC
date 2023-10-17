import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpront","password");
        Statement st =con.createStatement();

        //executeUpdate():DML için kullanılır;INSERT INTO,UPDATE,DELETE
        //return:sorgudan etkilenen kayıt sayısı döndürür(INT)

        System.out.println("-----------------1--------------------------");

        //ÖRNEK1:it_persons tablosunda maaşı ortalama maaştan az olanların maaşını 5111 olarak güncelleyiniz.
//        String sql1="UPDATE it_persons SET salary=5111 WHERE salary<(SELECT AVG(salary) FROM it_persons)";
//        int updated=st.executeUpdate(sql1);
//        System.out.println("güncellenen kayıt sayısı = " + updated);

        //tüm kayıtları görelim
        ResultSet rs =st.executeQuery("SELECT * FROM it_persons");
        while (rs.next()){
            System.out.println(rs.getString("name")+"---"+rs.getDouble("salary"));
        }

        System.out.println("------------------------2--------------------------");
//        ÖRNEK2:it_persons tablosuna yeni bir kayıt ekleyiniz.
//        String sql2="INSERT INTO it_persons(name,salary,prog_lang) VALUES('Yusuf',5000.0,'Java') ";
//        int inserted=st.executeUpdate(sql2);
//        System.out.println("eklenen kayıt sayısı = " + inserted);

        //tüm kayıtları görelim
        ResultSet rs2 =st.executeQuery("SELECT * FROM it_persons");
        while (rs2.next()){
            System.out.println(rs2.getString("name")+"---"+rs2.getDouble("salary")+"---"+rs2.getString("prog_lang"));
        }

        System.out.println("--------------------------3--------------------------");

        //ÖRNEK3:it_persons tablosundan id'si 11 olanı siliniz.
        String sql3="DELETE FROM it_persons WHERE id=11";
        int deleted=st.executeUpdate(sql3);
        System.out.println("silinen kayıt sayısı = "+deleted);

        ResultSet rs3 =st.executeQuery("SELECT * FROM it_persons");
        while (rs3.next()){
            System.out.println(rs3.getString("name")+"---"+rs3.getDouble("salary")+"---"+rs3.getInt("id"));
        }


        st.close();
        con.close();

    }
}
