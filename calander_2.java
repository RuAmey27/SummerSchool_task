import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


class Month {
    enum month {MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC,JAN,FEB};
    int year;
    int _month;
    String[] a;
    

    EnumSet<month> mymonth =  EnumSet.of(month.MAR, month.APR, month.MAY, month.JUN, month.JUL,month.AUG, month.SEP, month.OCT, month.NOV, month.DEC,month.JAN, month.FEB);
    // public StringBuilder monthCalendar;
    public String[] week= new String[7];

    public int getFirstTwoDigits(int num) {
        while (num >= 100) {
            num /= 10;
        }
        return num;
    }

    public int getLastTwoDigits(int num) {
        return num % 100;
    }

    public String getmonthName(int month) {
        String[] monthNames = { "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December", "January", "February" };
        return monthNames[month - 1];
    }

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

    Month(int year,int _month){
        this._month=_month;
        this.year=year;
    }

    public String make_month(int year , int _month){
        int C = getFirstTwoDigits(year);
        int D = getLastTwoDigits(year);
        String[] weekday = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        StringBuilder monthCalendar = new StringBuilder();

        // Add month name and weekdays
        monthCalendar.append(getmonthName(_month)).append("\n");
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
        int daysInmonth;
        switch (_month) {
            case 4:
            case 6:
            case 9:
            case 11:
                daysInmonth = 30;
                break;
            case 2:
                // Check for leap year
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    daysInmonth = 29;
                } else {
                    daysInmonth = 28;
                }
                break;
            default:
                daysInmonth = 31;
        }
//
        // Print the days of the month
        for (int day = 1; day <= daysInmonth; day++) {
            monthCalendar.append(day).append("\t");
            firstDay = (firstDay + 1) % 7;
            if (firstDay == 0) {
                 monthCalendar.append("\n");
            }
           
        }
        monthCalendar.append("\n");

        return monthCalendar.toString();

    }


    public static int daysInMonth(int _month, int year){
        int days;
        switch (_month) {
            case 2:  // April
            case 4:  // June
            case 7:  // September
            case 9: // November
                days = 30;
                break;
            case 12:  // February
                // Check for leap year
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default: // All other months
                days = 31;
        }
        return days;
    }

    public List<String> printMonth(int daysInMonth, int firstDay) {
        List<String> monthRows = new ArrayList<>();
        StringBuilder currentRow = new StringBuilder();
        
        // Add padding for the first row if the month doesn't start on Sunday
        for (int i = 0; i < firstDay; i++) {
            currentRow.append("\t");
        }

        // Print the days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            if(day<10){
                currentRow.append(day+" ").append("\t");
            }else{
                currentRow.append(day).append("\t");
            }
            
            firstDay = (firstDay + 1) % 7;
            if (firstDay == 0) {
                monthRows.add(currentRow.toString());
                currentRow = new StringBuilder();
            }
        }

        // Add the remaining days in the current row if any
        if (currentRow.length() > 0) {
            monthRows.add(currentRow.toString());
        }

        return monthRows;
    }
    // void displayweek(){
    //     System.out.println(make_month(this.year, this._month));
    //     // System.out.println(week[1]);
    //     // System.out.println(week[2]);

    // }
    // public void row(){
    //     this.a=make_month(this.year,this._month).split("\n");
    //     System.out.println(this.a.length);
    // }
    
    public void displamonth(int month){
        
        System.out.println(" ");
    }

    public static void printcalander(int row, int col, int year){
        Month[] arr= new Month[12];
        for (int i = 0; i < 12; i++) {
            
        }

    }
        // System.out.println(arr[0].a[0]+"\t\t\t"+arr[1].a[0]+"\t\t\t"+arr[2].a[0]+"\t\t\t"+arr[3].a[0]);
        // for (int j = 1; j < 7; j++) {
        //     System.out.println(arr[0].a[j]+"\t"+arr[1].a[j]+"\t"+arr[2].a[j]+"\t"+arr[3].a[j]);
        //     // System.out.print(arr[j].a[1]);   
        //     // System.out.print(arr[j].a[2]); 
        //     // System.out.print(arr[j].a[3]);
        //     // System.out.print(arr[j].a[4]);
        //     // System.out.print(arr[j].a[5]);
        //     // System.out.print(arr[j].a[6]);
        //     }
            
        // }


    


    public static void main(String[] args) {
        Month obj=new Month(2024, 2);
        
        // Month.printcalander(3,4,2024);

        List<String> calendarRows = obj.printMonth(daysInMonth(12,2024), day(1, 12, 20, 24)); // Example: 30 days in month, starting on a Wednesday (3)
        
        for (String row : calendarRows) {
            System.out.println(row);
        }

    }

    

}

///init block 
///static block
///constructor 
/// execution ++-+