import java.util.*;

/**
 * calander
 */
public class calander {

    public static int day(int K, int m, int C, int D) {
        if (m == 11 || m == 12) {
            D = D - 1;
            if (D < 0) { // To handle border cases like 2000, 1900
                C = C - 1;
                D = 99;
            }
        }

        int F = K + ((13 * m - 1) / 5) + D + (D / 4) + (C / 4) - 2 * C; // Zeller's rule
        int Ftemp = F;
        if (F < 0) {
            while (F % 7 != 0) {
                F = F - 1;
            }
            return Ftemp - F;
        } else {
            return F % 7;
        }
    }

    public static int getFirstTwoDigits(int num) {
        while (num >= 100) {
            num /= 10;
        }
        return num;
    }

    public static int getLastTwoDigits(int num) {
        return num % 100;
    }

    public static String getMonthName(int month) {
        String[] monthNames = { "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December", "January", "February" };
        return monthNames[month - 1];
    }

    public static String make_month(int year, int _month) {
        int C = getFirstTwoDigits(year);
        int D = getLastTwoDigits(year);
        String[] weekday = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        StringBuilder monthCalendar = new StringBuilder();

        // Add month name and weekdays
        monthCalendar.append(getMonthName(_month)).append("\n");
        for (String day : weekday) {
            monthCalendar.append(day).append("\t");
        }
        monthCalendar.append("\n");

        // Find the first day of the month
        int firstDay = day(1, _month, C, D);

        // Print leading spaces for the first week
        for (int i = 0; i < firstDay; i++) {
            monthCalendar.append("\t");
        }

        // Days in month
        int daysInMonth;
        switch (_month) {
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
            case 2:
                // Check for leap year
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                daysInMonth = 31;
        }

        // Print the days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            monthCalendar.append(day).append("\t");
            firstDay = (firstDay + 1) % 7;
            if (firstDay == 0) {
                monthCalendar.append("\n");
            }
        }
        monthCalendar.append("\n");

        return monthCalendar.toString();
    }

    public static void printYear(int year) {
        StringBuilder fullCalendar = new StringBuilder();

        // Print the first six months
        for (int i = 1; i <= 6; i++) {
            fullCalendar.append(make_month(year, i)).append("\t");
        }
        System.out.println("\n");
        // Print the next six months
        for (int i = 7; i <= 12; i++) {
            fullCalendar.append(make_month(year, i)).append("\t");
        }

        System.out.println(fullCalendar.toString());
    }

    

    public static void main(String[] args) {
        //printYear(1875); // Example usage

        System.out.println(week_builder(2024, 1, 4) );
    }

}



// hereSun Mon Tue Wed Thurs Fri Sat
// 0 1 2 3 4 5 6

// March is 1, April is 2….. January is 11 and February is 12.

// Need to implement condition for jan and feb of subtracting year

// class A{ public static void main(){ String x;System.out.println(x);}}

// when we use String built in method they internally create new object in heap
// but while using + i.e concatentation it will not creat new object in heap
// jshell> String s="amey"
// s ==> "amey"

// jshell> s.reapeat(2)==s+s
// | Error:
// | cannot find symbol
// | symbol: method reapeat(int)
// | s.reapeat(2)==s+s
// | ^-------^

// jshell> s.r
// regionMatches( repeat( replace( replaceAll( replaceFirst(
// resolveConstantDesc(
// jshell> s.repeat(2)==s+s
// $12 ==> false

// always use strobj1.equals(strobj2) while comparing string

// class Test{
// public int checkperformance()
// }