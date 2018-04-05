import java.util.*

private fun hurdleRace(k: Int, height: IntArray): Int {
    var k = k
    var beverages = 0

    for (i in 0 until height.size) {
        val current = height[i]
        if (current > k) {
            beverages += current - k
            k = current
        }
    }

    return beverages
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val k = scanner.nextInt()
    val height = IntArray(n)

    for (height_i in 0 until n) {
        height[height_i] = scanner.nextInt()
    }
    scanner.close()

    val result = hurdleRace(k, height)
    println(result)
}
