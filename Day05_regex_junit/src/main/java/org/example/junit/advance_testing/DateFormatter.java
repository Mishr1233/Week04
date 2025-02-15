package org.example.junit.advance_testing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public String formatDate(String inputDate) {
        if (inputDate == null || inputDate.isEmpty()) {
            return null;
        }

        //Define the expected format (yyyy-MM-dd)
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputFormat.setLenient(false);

        //Try to parse the input date
        try {
            Date date = inputFormat.parse(inputDate);

            //Define the output format (dd-MM-yyyy)
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            return outputFormat.format(date);
        } catch (ParseException e) {
            //If the date is invalid, return null or handle the error as per your requirement
            return null;
        }
    }
}
