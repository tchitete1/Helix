# Finds longest AGATC STR in input DNA sequence for later comparison against
# DNA database to find match
def findMaxShortTandemRepeatCounts(sequence, shortTandemRepeats, shortTandemRepeatCounts):
    for Str in shortTandemRepeats:
        # Stores STR counts of current STR
        StrCounts = []
        for nucleotide in range(len(sequence)):
            reps = 0
            beginIndex = nucleotide
            endIndex = nucleotide + len(Str)
            while sequence[beginIndex:endIndex] == Str:
                reps += 1
                beginIndex += len(Str)
                endIndex += len(Str)
            StrCounts.append(reps)
        shortTandemRepeatCounts.append(str(max(StrCounts)))

# Compares profile created from sequence against database to find match
def findMatch(profile, database):
    match = "No match"
    for row in database:
        if row[1:] == profile:
            match = row[0]
    print(match)