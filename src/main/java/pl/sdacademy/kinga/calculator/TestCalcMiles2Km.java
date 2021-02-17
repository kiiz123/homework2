package pl.sdacademy.kinga.calculator;

import java.util.Scanner;

public class TestCalcMiles2Km {
    public static void main(String[] args) {

        if (args.length > 0 ) {
            readParamsFromCommandLine(args);
        }
        else {
            ReadUserValues();
        }

    }
    public static void ReadUserValues() {
        String input;
        do {
            System.out.println("Podaj długość w milach (liczba rzeczywista)");
            input = readValue();
        } while (!testMilesFormat(input));
        RoadLength roadLength = new RoadLength(convert2Double(input), RoadLength.IN_MILES);
        System.out.println(roadLength);

    }

    public static String readValue() {
        Scanner scanner = new Scanner(System.in);
        return(scanner.next());

    }
    public static void readParamsFromCommandLine(String[] args)
    {
        System.out.println("Przetwarzamy parametry wejściowe");
        for (String input: args
        ) {
            if ( testMilesFormat(input) ) {
                RoadLength roadLength = new RoadLength(convert2Double(input), RoadLength.IN_MILES);
                System.out.println(roadLength);
            }
            else {
                System.out.println("Zły format:"+input);
            }
        }
    }
    public  static boolean testMilesFormat ( String miles ) {

        boolean match = miles.matches("^\\d+(\\.\\d+)?$");
        return match;
    }
    public static double convert2Double (String miles) {
        return(Double.parseDouble(miles));
    }
}
