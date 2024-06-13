package org.yugal;

public class Main {
    public static void main(String[] args) {
        //System.out.println(isWithin365Days("28/04/2023", "23/04/2024"));
        System.out.println(20250428 >= 20240423);
    }

    // Function to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Function to parse the date string into day, month, and year
    private static int[] parseDate(String dateStr) {
        String[] parts = dateStr.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        return new int[]{day, month, year};
    }

    // Function to get the total number of days from 01/01/0001 to the given date
    private static int daysFromEpoch(int day, int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;

        // Add days for the years
        for (int y = 1; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        // Adjust for leap year
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Add days for the months in the current year
        for (int m = 0; m < month - 1; m++) {
            totalDays += daysInMonth[m];
        }

        // Add days for the current month
        totalDays += day;

        return totalDays;
    }

    // Function to check if the difference between two dates is <= 365 days
    public static boolean isWithin365Days(String dateStr1, String dateStr2) {
        int[] date1 = parseDate(dateStr1);
        int[] date2 = parseDate(dateStr2);

        int daysDate1 = daysFromEpoch(date1[0], date1[1], date1[2]);
        int daysDate2 = daysFromEpoch(date2[0], date2[1], date2[2]);

        int difference = Math.abs(daysDate1 - daysDate2);

        return difference <= 365;
    }

    public static void dateTest(String date) {

        System.out.println(date);
    }

}