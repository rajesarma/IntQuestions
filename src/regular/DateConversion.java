package regular;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConversion {
    public static void main(String[] args) {
        String dateString = "25/10/2020";

        // first way
        LocalDate dateTime = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Date sqlDate1 = Date.valueOf(dateTime);//converting string into sql date
        System.out.println(sqlDate1);

        // second way
        try {
            java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());//converting string into sql date
            System.out.println(sqlDate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
