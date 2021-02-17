package pl.sdacademy.kinga.localDateExercise;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalDateExercise {

    public static void main(String[] args) {

        boolean[] isValid = new boolean[args.length];
        int count = 0;
        for (int i=0;i<args.length;i++) {
            String slocalDate = args[i];


            if ( checkLocalDateFormat(slocalDate) ) {
                isValid[i] = true; count++;
                System.out.println("Wczytano poprawną datę: "+slocalDate);
            }
            else {
                isValid[i] = false;
                System.out.println("Wczytano niepoprawną datę: "+slocalDate);
            }
        }
        if ( count == 0 ) {
            System.out.println("Nie podano ŻADNEJ poprawnej daty");
            return;
        }

        LocalDate[] validLocalDates = copyOnlyValidDates(args,isValid,count);

        System.out.println("Poprawne daty:");
        LocalDate nowLocalDate = LocalDate.now();
        for (LocalDate d: validLocalDates
             ) {
            Period period = Period.between(d,nowLocalDate);
            System.out.println(d+" Odstęp czasowy od "+nowLocalDate+" wynosi w latach "
                    + period.getYears()+", w miesiącach "+period.getMonths()+" w dniach "+period.getDays());
        }

        System.out.println("Najmniejsza data="+validLocalDates[getIndexOfMinDate(validLocalDates)]);
        System.out.println("Największa data="+validLocalDates[getIndexOfMaxDate(validLocalDates)]);

    }

    public static LocalDate[] copyOnlyValidDates(String[] AllDates, boolean[] validDates, int howManyValid) {
        int vIndex=0;
        LocalDate[] returnedDates = new LocalDate[howManyValid];

        for (int i=0; i< AllDates.length;i++)
        {
            if (validDates[i]) {
                returnedDates[vIndex] = LocalDate.parse(AllDates[i]);
                vIndex++;
            }
        }
        return returnedDates;
    }

    public static int getIndexOfMinDate (LocalDate[] dates)
    {
        int minIndex=0;

        for (int i=0;i<dates.length;i++) {
            if (dates[i].isBefore(dates[minIndex])) {
                minIndex=i;
            }
        }
        return minIndex;
    }

    public static  int getIndexOfMaxDate (LocalDate[] dates)
    {
        int maxIndex=0;

        for (int i=0;i<dates.length;i++) {
            if (dates[i].isAfter(dates[maxIndex])) {
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    public static boolean checkLocalDateFormat (String date) {
        boolean result = date.matches("^\\d{4}-\\d{2}-\\d{2}$");
        if (!result) {
            return false;
        }

        Pattern pattern = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})$");
        Matcher matcher = pattern.matcher(date);

        int year ;
        int month ;
        int day ;

        if (matcher.find()) {
            year = Integer.parseInt(matcher.group(1));
            month = Integer.parseInt(matcher.group(2));
            day = Integer.parseInt(matcher.group(3));
        }
        else {
            return false;
        }
        if ( day > 31) {
            return false;
        }
        else if ( month > 12) {
            return false;
        }
        else {
            return(true);
        }

    }

}
