import csv
import sys

def main():
    numOfArgs = len(sys.argv) - 1

    # Error message to screen so user understands if they have provided the
    # incorrect number of command line arguments
    if numOfArgs != 2:
        print("Usage: python Helix.py <database> <sequence>")
    else:
        # Opens file at index 1 of the command line (DNA database) and reads it into
        # memory for later comparison
        database = open(sys.argv[1])
        databaseCSV = csv.reader(database)

        # Opens file at index 2 of the command line (DNA sequence) and reads it into
        # memory for later comparison
        seq = open(sys.argv[2], "r").read()

        # Executes profiling using STRs found in small database if its use is
        # specified (via the second command line argument)
        STRCounts = []
        if sys.argv[1] == "Databases/Small.csv":
            smallDatabaseSTRs = [
                "AGATC",
                "AATG",
                "TATC"
            ]
            for Str in smallDatabaseSTRs:
                findHighestNumOfSTRReps(STRCounts, seq, Str)
        # Executes profiling using STRs found in large database if its use is
        # specified (via the second command line argument)
        else:
            largeDatabaseSTRs = [
                "AGATC",
                "TTTTTTCT",
                "AATG",
                "TCTAG",
                "GATA",
                "TATC",
                "GAAA",
                "TCTG"
            ]
            for Str in largeDatabaseSTRs:
                findHighestNumOfSTRReps(STRCounts, seq, Str)

        findMatch(STRCounts, databaseCSV)

        database.close()

# Finds longest AGATC STR in input DNA sequence for later comparison against
# DNA database to find match
def findHighestNumOfSTRReps(STRCounts, seq, Str):
    STRRepsBuffer = []
    for nucleotide in range(len(seq)):
        STRReps = 0
        STRstart = nucleotide
        STRend = nucleotide + len(Str)
        while seq[STRstart:STRend] == Str:
            STRReps += 1
            STRstart += len(Str)
            STRend += len(Str)
        STRRepsBuffer.append(STRReps)
    STRCounts.append(str(max(STRRepsBuffer)))

# Compares profile created from sequence against database to find match
def findMatch(profile, databaseCSV):
    match = "No match"
    for row in databaseCSV:
        if row[1:] == profile:
            match = row[0]
    print(match)

if __name__ == "__main__":
    main()