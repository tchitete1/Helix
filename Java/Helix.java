/*
 * NAME: Helix
 * CREATOR: Tanaka Chitete
 * PURPOSE: Identify a person based on a sample of their DNA profile.
 * CREATION: 25/02/2021
 * LAST MODIFICATION: 25/02/2021
 */

public class Helix {
    public static final int REQ_ARGC = 2;

    public static void main(String[] args) {
        if (args.length != REQ_ARGC) {
            System.out.println("Usage: java Helix.java <database> <sequence>");
        }
        else {
            String[][] database = Reader.readDatabase(args[0]);
            String sequence = Reader.readSequence(args[1]);

            // Prepares to profile <sequence> using STRs found in Small.csv
            String[] shortTandemRepeats;
            int[] shortTandemRepeatCounts;
            if (args[0].equals("Databases/Small.csv")) {
                shortTandemRepeatCounts = new int[3];
                shortTandemRepeats = new String[] {
                    "AGATC",
                    "AATG",
                    "TATC"
                };
            }
            // Prepares to profile <sequence> using STRs found in Large.csv
            else {
                shortTandemRepeatCounts = new int[8];
                shortTandemRepeats = new String[] {
                    "AGATC",
                    "TTTTTTCT",
                    "AATG",
                    "TCTAG",
                    "GATA",
                    "TATC",
                    "GAAA",
                    "TCTG"
                };
            }

            // Find highest repetition count of each STR in shortTandemRepeats found within 
            // sequence, storing counts in shortTandemRepeatCounts
            Profiler.findMaxShortTandemRepeatCounts(sequence, shortTandemRepeats, shortTandemRepeatCounts);

            // Attempts to find matching person in database by comparing stored STR counts for each
            // individual to shortTandemRepeat counts, outputting name of matching person if found,
            // otherwise, "No match"
            Profiler.findMatch(database, shortTandemRepeatCounts);
        }
    }
}