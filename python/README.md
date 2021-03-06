# Helix

```helix``` is a Command-Line program written in Python which identifies a person based on a sample of their DNA profile

## Description

The program works by analysing Short Tandem Repeats (STRs)–short sequences of DNA bases present in a person's DNA which
tend to repeat. Helix reads a user-specified DNA sequence along with a CSV file containing STR counts for various individuals
into memory. Ultimately, the program obtains the counts of various STRs present in the DNA and if they match to a person in
the database, the name of the matching individual will be output to the terminal, otherwise, "No Match" will be output instead. 

## Getting Started

### Installation

1. Install the ```helix``` archive by downloading [```helix-master.zip```](https://github.com/tchitete1/helix/archive/master.zip)
2. Open a new terminal window in the directory where the archive was downloaded
3. Unzip the archive using the following command to obtain the ```helix-master``` directory:
```
unzip helix-master.zip
```
4. Delete the archive using the following command:
```
rm helix-master.zip
```
5. Change into the ```helix-master/python``` directory by executing the following command:
```
cd helix-master/python
```

### Execution

* To execute ```helix```, execute the following:
```
python helix.py <database> <sequence>
```
where ```database``` is one of the databases storing the STR counts of different individuals, located in the ```databases``` 
directory and ```sequence``` is the DNA sequence we seek to analyse to determine a match, located in the ```sequences``` directory. For example,
```
python helix.py databases/large.csv sequences/15.txt
```
The expected output for the above is ```Sirius```.

## Author

Tanaka Chitete
* [LinkedIn](https://www.linkedin.com/in/tanaka-chitete/)

## Acknowledgments

* Thank you to [DomPizzie](https://github.com/DomPizzie) for the [template](https://gist.github.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc)
