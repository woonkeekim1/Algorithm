import java.util.*;
import java.math.BigInteger;
public class BoomBoy {
  public static void main(String[] args) {
    System.out.println(answer("5", "9"));
    System.out.println(answer("17", "9"));
    System.out.println(answer("100", "9"));
  }
  public static String answer(String M, String F) {
        // Your code goes here.
        BigInteger steps = new BigInteger("0");
        BigInteger remainder = new BigInteger(M);
        BigInteger value = new BigInteger(F);
        if(remainder.compareTo(value) > 0) {
            BigInteger tmp = remainder;
            remainder = value;
            value = tmp;
        }
        while(remainder.compareTo(BigInteger.ONE) > 0) {
            steps = steps.add(value.divide(remainder));
            BigInteger tmp = value.mod(remainder);
            value = remainder;
            remainder = tmp;
        }
        if(remainder.equals(BigInteger.ZERO)) {
            return "impossible";
        }
        return steps.add(value.subtract(BigInteger.ONE)).toString();
    }
}
