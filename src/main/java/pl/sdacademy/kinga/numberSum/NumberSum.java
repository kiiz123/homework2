package pl.sdacademy.kinga.numberSum;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberSum {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Brak parametrów wywołania - liczb całkowitych");
            return;
        }

        for (String value: args
             ) {
            if (checkValue(value)) {
                long number = Long.parseLong(value);
                long sum = sumsum(number);

                long OneDigitSum=sum;
                while (OneDigitSum>9)
                {
                    OneDigitSum=sumsum(OneDigitSum);
                }

                System.out.println("Suma liczb w " + number + " to " + sum+ ", suma jednocyfrowa to "+OneDigitSum);
            }
            else
            {
                System.out.println(value+" nie jest liczbą całkowitą dodatnią");
            }
        }

    }
    public static long sumsum(long number) {
        if (number<10) {
            return number;
        }
        else {
            long abs = number/10;
            long remainder = number%10;
            return(sumsum(abs)+remainder);
        }
    }
    public static String readValue() {
        Scanner scanner = new Scanner(System.in);
        return(scanner.next());
    }


    public static boolean checkValue(String value) {
        return(value.matches("^\\d+$"));
    }


}
