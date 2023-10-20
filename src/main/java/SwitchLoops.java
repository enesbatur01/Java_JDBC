import java.util.Scanner;

public class SwitchLoops {
    public static void main(String[] args) {
        String cardNum = "1234 5678 9123 4567";
    //verilen kredi kartı numarasında son 4 dışındaki bütün rakamları  "*" a çeviriniz "
        cardNum = cardNum.substring(0,cardNum.length()-4).replaceAll("[0-9]","*")+cardNum.substring(cardNum.length()-4);
        System.out.println(cardNum);







                  /*
                            Meshur Regex'ler

        1) Tum rakamlar ==> [0-9]
        2) Tum kucuk harfler ==> [a-z]
        3) Tum buyuk harfler ==> [A-Z]
        4) Tum kucuk harfler ve buyuk harfler ==> [a-zA-Z]
        5) Tum harfler ve rakamlar ==> [a-zA-Z0-9]
        6) Tum noktalama isaretleri ==> \\p{Punct}
        7) Tum sesli harfler ==> [aeiouAEIOU]
           x, q, w harfleri ==> [xqw]

        8) Kucuk harflerden farkli tum character'ler ==> [^a-z]
        9) Tum harflerden farkli tum character'ler ==> [^a-zA-Z]

        Bu kisim da [] kullanilmaz. Buyuk harfler olumsuz anlama gelir
        Sadece space karakteri : \\s
        Space karakteri haric  : \\S
        Sadece rakamlar        : \\d  (digit ten geliyor)
        Rakamlar haric         : \\D
        */

    }
}
