import java.math.BigDecimal;

public class TestJava {
    public static void main(String[] args) {

        String s = "-100.00";

        BigDecimal b = new BigDecimal(s);

        System.out.println(b.toString());


//        System.out.println(100%100);

//        String s = "1";
//        s = s.substring(0, s.length()-1);
//        System.out.println("s=" + s);

//        StringBuffer s = new StringBuffer("Hello");
//        s.insert(2,'[');
//        System.out.println(s);
//
//        BigDecimal d = new BigDecimal(-1.01);
//
//        if (d.compareTo(BigDecimal.ZERO) < 0){
//            System.out.println("True");
//        }
//
//        if (d.longValue() < 0){
//            System.out.println("Hello");
//        }
//        System.out.println("World");
    }
}
