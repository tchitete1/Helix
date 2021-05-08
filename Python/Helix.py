"""
NAME: Helix
CREATOR: Tanaka Chitete
PURPOSE: Identify a person based on a sample of their DNA profile.
CREATION: 12/11/2020
LAST MODIFICATION: 25/02/2021
"""

import csv
import sys
from Profiler import findMaxShortTandemRepeatCounts, findMatch

def main():
    if len(sys.argv) != 3:
        print("Usage: python Helix.py <database> <sequence>")
    else:
        fileObject = open(sys.argv[1])
        database = csv.reader(fileObject)
        sequence = open(sys.argv[2], "r").read()

        shortTandemRepeatCounts = []
        # Prepares to profile <sequence> using STRs found in Small.csv
        if sys.argv[1] == "databases/small.csv":
            shortTandemRepeats = [
                "AGATC",
                "AATG",
                "TATC"
            ]
        # Prepares to profile <sequence> using STRs found in Large.csv
        else:
            shortTandemRepeats = [
                "AGATC",
                "TTTTTTCT",
                "AATG",
                "TCTAG",
                "GATA",
                "TATC",
                "GAAA",
                "TCTG"
            ]

        # Finds highest repetition count of each STR found within sequence, storing counts in
        # shortTandemRepeatCounts
        findMaxShortTandemRepeatCounts(sequence, shortTandemRepeats, shortTandemRepeatCounts)

        # Attempts to find matching person in database by comparing stored STR counts for each
        # individual to shortTandemRepeat counts, outputting name of matching person if found,
        # otherwise "No match"
        findMatch(shortTandemRepeatCounts, database)

        fileObject.close()

if __name__ == "__main__":
    main()