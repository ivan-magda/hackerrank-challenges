class Main {

    private static int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }

        return count;
    }

    private static int countSetBitsRecursive(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (n & 1) + countSetBits(n >> 1);
        }
    }

    private static int countSetBitsKernighan(int n) {
        int count = 0;

        while (n > 0) {
            n &= (n - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(3));
        System.out.println(countSetBits(2));
        System.out.println("******************");
        System.out.println(countSetBitsRecursive(3));
        System.out.println(countSetBitsRecursive(2));
        System.out.println("******************");
        System.out.println(countSetBitsKernighan(3));
        System.out.println(countSetBitsKernighan(2));
    }
}
