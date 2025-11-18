
/*
 * Class: CMSC203 
 * Instructor:Shah Madhvi
 * Description: This program loads retail sales data, calculates totals and holiday bonuses, 
 * and displays the results in a JavaFX GUI with highlighted highest and lowest values.
 * Due: 11/17/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Leika Ray Joseph
*/


public class HolidayBonus {

    public static final double HIGH_BONUS = 5000.0;
    public static final double LOW_BONUS = 1000.0;
    public static final double OTHER_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        // Find max number of columns
        int maxCols = 0;
        for (double[] row : data)
            if (row.length > maxCols)
                maxCols = row.length;

        for (int col = 0; col < maxCols; col++) {

            double highest = Double.NEGATIVE_INFINITY;
            double lowest = Double.POSITIVE_INFINITY;
            int count = 0;

            // Determine highest / lowest valid sales
            for (double[] row : data) {
                if (col < row.length && row[col] > 0) {
                    count++;
                    if (row[col] > highest) highest = row[col];
                    if (row[col] < lowest) lowest = row[col];
                }
            }

            if (count == 0) continue;

            // Special case: ONLY ONE store sold in this category
            if (count == 1) {
                for (int r = 0; r < data.length; r++) {
                    if (col < data[r].length && data[r][col] > 0)
                        bonuses[r] += HIGH_BONUS;
                }
                continue;
            }

            // Normal bonus distribution
            for (int r = 0; r < data.length; r++) {
                if (col >= data[r].length) continue;
                double sale = data[r][col];

                if (sale <= 0) continue;

                if (sale == highest)
                    bonuses[r] += HIGH_BONUS;
                else if (sale == lowest)
                    bonuses[r] += LOW_BONUS;
                else
                    bonuses[r] += OTHER_BONUS;
            }
        }

        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double sum = 0;
        double[] arr = calculateHolidayBonus(data);
        for (double d : arr)
            sum += d;
        return sum;
    }
}
