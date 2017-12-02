fun solve(n: Int, p: Int): Int {
    // Shifts this value right by 1 bit, filling the leftmost bits with copies of the sign bit.
    // equal to p / 2
    val front = p shr 1
    val back = if ((n and 1) == 1) {
        n - p shr 1 // odd number of pages
    } else {
        n - p + 1 shr 1 // even number of pages
    }

    return minOf(front, back)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val p = scanner.nextInt()
    val result = solve(n, p)
    println(result)
}
