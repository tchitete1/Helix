import java.util.*;

public class Profiler {
    /*
     * NAME: findMaxShortTandemRepeatCounts
     * IMPORT(S): sequence (String), shortTandemRepeats (String[]), shortTandemRepeatCounts (int[])
     * EXPORT(S): NONE
     * PURPOSE: Find highest repetition count of each STR in shortTandemRepeats found within 
     *          sequence, storing counts in shortTandemRepeatCounts
     * CREATION: 25/02/2021
     * LAST MODIFICATION: 25/02/2021
     */

    public static void findMaxShortTandemRepeatCounts(String sequence, String[] shortTandemRepeats, 
    int[] shortTandemRepeatCounts) {
        for (int i = 0; i < shortTandemRepeats.length; i++) {
            String Str = shortTandemRepeats[i];
            // Stores STR counts of current STR
            ArrayList<Integer> StrCounts = new ArrayList<Integer>();
            for (int j = 0; j < sequence.length(); j++) {
                int reps = 0;
                int beginIndex = j;
                int endIndex = j + Str.length();

                while ((endIndex < sequence.length()) && sequence.substring(beginIndex, endIndex).equals(Str)) {
                    reps++;
                    beginIndex += Str.length();
                    endIndex += Str.length();
                }

                StrCounts.add(reps);
            }
            shortTandemRepeatCounts[i] = Collections.max(StrCounts);
        }
    }

    /*
     * NAME: findMatch
     * IMPORT(S): sequence (String), shortTandemRepeats (String[]), shortTandemRepeatCounts (int[])
     * EXPORT(S): NONE
     * PURPOSE: Attempts to find matching person in database by comparing stored STR counts for each
     *          individual to shortTandemRepeat counts, outputting name of matching person if found,
     *          otherwise, "No match"
     * CREATION: 25/02/2021
     * LAST MODIFICATION: 25/02/2021
     */

    public static void findMatch(String[][] database, int[] shortTandemRepeatCounts) {
        String match = "No match";
        for (int i = 1; i < database.length; i++) {
            if (isMatch(shortTandemRepeatCounts, database, i)) {
                match = database[i][0];
            }
        }
        System.out.println(match);
    }

    /*
     * NAME: isMatch
     * IMPORT(S): shortTandemRepeatCounts (int[]), database (String[][]), profileIndex (int)
     * EXPORT(S): isMatch (boolean)
     * PURPOSE: Check if profile found at database[profileIndex] matches shortTandemRepeat counts,
     *          returning true if so, otherwise, false
     * CREATION: 25/02/2021
     * LAST MODIFICATION: 25/02/2021
     */

    private static boolean isMatch(int[] shortTandemRepeatCounts, String[][] database, int profileIndex) {
        boolean isMatch = true;
        int j = 0;
        while (isMatch && (j < shortTandemRepeatCounts.length)) {
            if (shortTandemRepeatCounts[j] != Integer.valueOf(database[profileIndex][j + 1])) {
                isMatch = false;
            }
            j++;
        }

        return isMatch;
    }
}
