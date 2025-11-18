
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

import java.io.*;
import java.util.ArrayList;

public class TwoDimRaggedArrayUtility {

    /**
     * Reads a file and returns a ragged 2D array of doubles.
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        ArrayList<double[]> rows = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] tokens = line.trim().split(" ");
                double[] row = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Double.parseDouble(tokens[i]);
                }
                rows.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows.toArray(new double[rows.size()][]);
    }

    /**
     * Writes a ragged array into a file.
     */
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file);

        for (double[] row : data) {
            for (int i = 0; i < row.length; i++) {
                out.print(row[i]);
                if (i < row.length - 1)
                    out.print(" ");
            }
            out.println();
        }
        out.close();
    }

    /** Returns the total of the array */
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data)
            for (double val : row)
                total += val;
        return total;
    }

    /** Returns the average of the array */
    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;
        for (double[] row : data)
            for (double val : row) {
                total += val;
                count++;
            }
        return total / count;
    }

    /** Returns the total of a specified row */
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double v : data[row])
            total += v;
        return total;
    }

    /** Returns the total of a specified column */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data)
            if (col < row.length)
                total += row[col];
        return total;
    }

    /** Returns the highest value in a row */
    public static double getHighestInRow(double[][] data, int row) {
        double max = data[row][0];
        for (double v : data[row])
            if (v > max)
                max = v;
        return max;
    }

    /** Returns the index of the highest value in a row */
    public static int getHighestInRowIndex(double[][] data, int row) {
        double max = data[row][0];
        int idx = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
                idx = i;
            }
        }
        return idx;
    }

    /** Returns the lowest in a row */
    public static double getLowestInRow(double[][] data, int row) {
        double min = data[row][0];
        for (double v : data[row])
            if (v < min)
                min = v;
        return min;
    }

    /** Returns the index of the lowest value in the row */
    public static int getLowestInRowIndex(double[][] data, int row) {
        double min = data[row][0];
        int idx = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
                idx = i;
            }
        }
        return idx;
    }

    /** Returns the highest in a column */
    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data)
            if (col < row.length && row[col] > max)
                max = row[col];
        return max;
    }

    /** Returns the index of the highest in a column */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        int idx = -1;
        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length && data[r][col] > max) {
                max = data[r][col];
                idx = r;
            }
        }
        return idx;
    }

    /** Returns the lowest value in a column */
    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data)
            if (col < row.length && row[col] < min)
                min = row[col];
        return min;
    }

    /** Returns the index of the lowest value in a column */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        int idx = -1;
        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length && data[r][col] < min) {
                min = data[r][col];
                idx = r;
            }
        }
        return idx;
    }

    /** Returns the highest value in the array */
    public static double getHighestInArray(double[][] data) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data)
            for (double v : row)
                if (v > max)
                    max = v;
        return max;
    }

    /** Returns the lowest value in the array */
    public static double getLowestInArray(double[][] data) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data)
            for (double v : row)
                if (v < min)
                    min = v;
        return min;
    }
}
