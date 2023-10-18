import org.junit.Assert;
import org.junit.Test;

public class JunitTest {
    /*
    Assertion: Test sonuçlarını doğrulamak için kullanacağımız class ve methodlardır.
    Test geçti veya kaldı şeklinde dönütler alabilmek için doğrulama(assertion) işlemi gerçekleştiririz
     */


    //ASSERTION TÜRLERİ:
    // 1. assertEquals() --> İçerisine eklenen parametreler eşitse test geçer, değilse kalır.
    @Test
    public void deneme1(){
        String expectedData="Selam";
        String actualData="Selam";

        Assert.assertEquals(expectedData,actualData);
    }

    //2. assertTrue() --> Içerisine eklenen işlem sonucu true ise test geçer, false ise kalır
    @Test
    public void deneme2(){
        int num1=5;

        Assert.assertTrue(num1>0);

    }

    //3. assertNotEquals() -->  Içerisine eklenen parametreler eşit değilse test geçer, eşitse kalır.
    @Test
    public void deneme3(){
        int num1=5;
        int num2=2;

        Assert.assertNotEquals(num1,num2);

    }

    //4. assertFalse() --> Içerisine eklenen işlem sonucu false ise test geçer, true ise kalır.
    @Test
    public void deneme4(){
        int num1=5;

        Assert.assertFalse(num1 < 0);

    }







}