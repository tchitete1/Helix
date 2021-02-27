import java.io.*;

public class Reader {
    /*
     * NAME: readCSV
     * IMPORT(S): filename (String)
     * EXPORT(S): contents (String[][])
     * PURPOSE: Read contents of CSV file into a 2D array
     * CREATION: 25/02/2021
     * LAST MODIFICATION: 25/02/2021
     */

    public static String[][] readDatabase(String filename) {
        int rowCount = getRowCount(filename);
        int columnCount = getColumnCount(filename);
        String[][] contents = new String[rowCount][columnCount];

        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String line;
        String[] splitLine = new String[columnCount];

        try {
            fileInputStream = new FileInputStream(filename);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            line = bufferedReader.readLine();

            // Reads contents into array
            int i = 0;
            while (line != null) {
                splitLine = line.split(",");
                for (int j = 0; j < splitLine.length; j++) {
                    contents[i][j] = splitLine[j];
                }
                line = bufferedReader.readLine();

                i++;
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                catch (IOException ex2) { 
                } 
            }
            throw new IllegalArgumentException("File reading unsuccessful");
        }

        return contents;
    }

    /*
     * NAME: readSequence
     * IMPORT(S): filename (String)
     * EXPORT(S): contents (String)
     * PURPOSE: Read contents of TXT file into a String
     * CREATION: 25/02/2021
     * LAST MODIFICATION: 25/02/2021
     */

    public static String readSequence(String filename) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String line;
        String sequence;

        try {
            fileInputStream = new FileInputStream(filename);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            line = bufferedReader.readLine();
            if (line == null) {
                sequence = "";
            }
            else {
                sequence = line;
            }

            bufferedReader.close();
        }
        catch (IOException e) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                catch (IOException ex2) { 
                } 
            }
            throw new IllegalArgumentException("File reading unsuccessful");
        }

        return sequence;
    }

    /*
     * NAME: getRowCount
     * IMPORT(S): filename (String)
     * EXPORT(S): NONE
     * PURPOSE: Counts the number of rows a CSV file contains
     * CREATION: 20/10/2020
     * LAST MODIFICATION: 25/02/2021
     */

    private static int getRowCount(String filename) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String line;

        int rowCount = 0;

        try {
            fileInputStream = new FileInputStream(filename);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            line = bufferedReader.readLine();

            // Counts lines
            while (line != null) {
                rowCount++;

                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                catch (IOException e2) {
                }
            }
            System.out.println("Could not count rows");
        }

        return rowCount;
    }


    /*
     * NAME: getColumnCount
     * IMPORT(S): filename (String)
     * EXPORT(S): NONE
     * PURPOSE: Counts the number of columns a CSV file contains
     * CREATION: 25/02/2021
     * LAST MODIFICATION: 25/02/2021
     */

    private static int getColumnCount(String filename) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String line;

        int columnCount = 0;
        try {
            fileInputStream = new FileInputStream(filename);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            line = bufferedReader.readLine();

            if (line != null) {
                String[] splitLine = line.split(",");
                columnCount = splitLine.length;
            }

            bufferedReader.close();
        }
        catch (IOException e) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                catch (IOException e2) {
                }
            }
            System.out.println("Could not count columns");
        }

        return columnCount;
    }
}
