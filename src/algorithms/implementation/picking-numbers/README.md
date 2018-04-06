# Counting Valleys

Our goal is to count the number of valleys. A valley is a sequence of steps starting with a step downward from sea level and ending with a step upward to sea level. Let `level` be a variable denoting the current height. If we take a step upwards, `level`  is incremented by one; if we take step downwards, `level`  is decremented by one.


Since we know that the sequence of input steps starts and ends at ground level, then we can say that our variable is 0 at the beginning and end of the hike. The number of valleys can be counted as the number of steps taken upwards to sea level (i.e., when `level` goes from -1 to 0. This is true, because each such step ends the sequence of steps below sea level, signifying the end of a valley.

[Description](https://www.hackerrank.com/challenges/counting-valleys)

### Build and Run

#### Kotlin

To compile the application using the Kotlin compiler, open your terminal and type:
```bash
kotlinc Main.kt -include-runtime -d main.jar
```

To run the application, use:
```bash
java -jar main.jar
```
