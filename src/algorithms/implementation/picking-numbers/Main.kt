import java.util.*


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    val frequency = IntArray(100 + 1)

    // Fill array so that the value at each index corresponds to the number of occurrences of that integer
    for (i in 0 until n) {
        frequency[scanner.nextInt()]++
    }
    scanner.close()

    // Determine which pair of adjacent integers has the highest number of occurrences
    var max = 0
    for (i in 1..100) {
        val count = frequency[i] + frequency[i - 1]
        if (count > max) {
            max = count
        }
    }

    println(max)
}
