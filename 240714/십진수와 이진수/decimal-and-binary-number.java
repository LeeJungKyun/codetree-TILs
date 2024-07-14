import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String binaryStr = scanner.nextLine().trim();
        
        BigInteger decimalValue = new BigInteger(binaryStr, 2);
        
        BigInteger multipliedValue = decimalValue.multiply(BigInteger.valueOf(17));
        
        String resultBinaryStr = multipliedValue.toString(2);
        
        System.out.println(resultBinaryStr);
        
        scanner.close();
    }
}