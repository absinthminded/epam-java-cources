package com.epam.university.java.core.task017;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

public class Task017Impl implements Task017 {

    @Override
    public String formatString(Object... args) {
        paramChecker(args);
        String result = "You know ";

        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0) {
                result += args[i];
            } else {
                result += ", " + args[i] + "!";
            }
        }

        return result;
    }

    @Override
    public String formatNumbers(Object... args) {
        paramChecker(args);

        Double input = Double.valueOf(Arrays.toString(args)
                             .replace("[", "")
                             .replace("]", ""));

        NumberFormat formatter = new DecimalFormat("#0.00");
        NumberFormat forPlusSign = new DecimalFormat("+#0.00");


        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(input)
                        .append(", ")
                        .append(formatter.format(input))
                        .append(", ")
                        .append(forPlusSign.format(input))
                        .append(", ")
                        .append(Double.toHexString(input));


        return stringBuilder.toString();
    }


    @Override
    public String formatDates(Object... args) {
        paramChecker(args);

        String input = Arrays.toString(args).replace("[", "").replace("]", "");
        DateFormat inputFormat = new SimpleDateFormat("E MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
        DateFormat outputFormat = new SimpleDateFormat("yyyy.dd.MM");
        String resultDate = "";

        try {
            resultDate = outputFormat.format(inputFormat.parse(input));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resultDate;
    }


    /**
     * Function to validate parameters.
     * @param args parameter to check.
     */
    public void paramChecker(Object... args)  {
        if (args == null || args.length == 0 || args[0] == null) {
            throw new IllegalArgumentException();
        }
    }
}
