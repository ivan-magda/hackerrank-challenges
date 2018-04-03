import java.util.*

private fun getValleyCount(steps: String): Int {
    var countValley = 0
    var level = 0

    for (step in steps) {
        if (level == -1 && step == 'U') {
            countValley++
        }

        if (step == 'U') {
            level++
        } else {
            level--
        }
    }

    return countValley
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    scanner.nextInt()
    val steps = scanner.next()
    scanner.close()

    println(getValleyCount(steps))
}
