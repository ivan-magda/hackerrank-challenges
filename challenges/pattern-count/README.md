# Pattern Count

## Problem description

A string `s` contains many patterns of the form `1(0+)1` where `(0+)` represents any non-empty consecutive sequence of 0's. The patterns are allowed to overlap.

For example, consider string `1101001`, we can see there are two consecutive sequences `1(0)1` and `1(00)1` which are of the form `1(0+)1`.


You have to answer `q` queries, each containing a string `s`. For each query, find and print the total number of patterns that occur in string.

### Sample Input

```
3
100001abc101
1001ab010abc01001
1001010001
```

### Sample Output

```
2
2
3
```