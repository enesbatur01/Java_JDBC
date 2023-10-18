public class IlkTest {
    /*
    Expected Data: Beklenen data
    Actual Data: Gerçek data

    Test: Beklenen data ile gerçek datanın karşılaştırılmasıdır
     */

    public static void main(String[] args) {
        //TEST-1
        String expectedData="Selam";
        String actualData="Selam";

        if (actualData.equals(expectedData)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //TEST-2
        int num1=5;
        int num2=5;
        if (num1==num2){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        //TEST-3
        if (num1>num2){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }


        // Otomasyon testi iyapabilmek için bir Test Framework'üne ihtiyacımız vardır (JUnit, TestNG, Cucumber)





    }
}
