/**
 * Inplace merge two sorted arrays.
 */
class Main {

    private static void printArray(int A[]) {
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");        
        System.out.println();
    }

    // in-place merge two sorted arrays X[] and Y[]
    // invariant: X[] and Y[] are sorted at any point
    public static void merge(int X[], int Y[]) {
        int m = X.length;
        int n = Y.length;

        int i = 0;

        // consider each element X[i] of array X and ignore the element
        // if it is already in correct order else swap it with next smaller
        // element which happens to be first element of Y
        while (i < m) {
            // compare current element of X[] with first element of Y[]
            if (X[i] > Y[0]) {
                // swap (X[i], Y[0])
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;
                
                int first = Y[0];
     
                // move Y[0] to its correct position to maintain sorted
                // order of Y[]. Note: Y[1..n-1] is already sorted
                int k;
                for (k = 1; k < n && Y[k] < first; k++)
                    Y[k - 1] = Y[k];
     
                Y[k - 1] = first;
            }
            i++;
        }
    }

    public static void main (String[] args) {
        int X[] = { 1, 4, 7, 8, 10 };
        int Y[] = { 2, 3, 9 };

        int m = X.length;
        int n = Y.length;

        merge(X, Y);

        System.out.print("X: "); printArray(X);
        System.out.print("Y: "); printArray(Y);
    }
}
