package com.baishakhee.nasaimageoftheday.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String formatDate(String inputDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM  yyyy", Locale.US);

            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return inputDate; // Return the original date if parsing fails
        }
    }

    public static void main(String[] args) {
        String inputDate = "2019-05-07";
        String formattedDate = formatDate(inputDate);
        System.out.println(formattedDate); // Output: "May 07, 2019 05:15 PM"
    }
}
