# Find index of 0 to be replaced to get maximum length sequence of continuous ones

Given a binary array, find the index of 0 to be replaced with 1 to get maximum length sequence of continuous ones.

### Approach:

We can efficiently solve this problem in linear time and constant space.
The idea is to traverse the given array and maintain index of previous zero encountered.
Then for each subsequent zeroes, we can easily find out number of 1’s between current zero and last zero.
For every element we check if maximum sequence of continuous 1’s ending at that element (including last zero which is now replaced by 1) exceeds maximum sequence found so far.
If yes, we update the maximum sequence to current sequence length and index of optimal zero to index of last zero encountered.

## Build and Run

To compile the file, open your terminal and type:
```
javac Main.java
```

To run the generated class file, use:
```
java Main
```
