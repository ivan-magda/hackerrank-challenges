import java.util.*
import kotlin.collections.ArrayList

fun weightedMean(data: List<Int>, weights: List<Int>): Float {
    var dataByWeight = 0F
    var weightsSum = 0

    for (i in 0 until data.size) {
        dataByWeight += data[i] * weights[i]
        weightsSum += weights[i]
    }

    return dataByWeight / weightsSum
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val length = scanner.nextInt()
    val values = ArrayList<Int>(length)
    val weights = ArrayList<Int>(length)

    for (i in 0 until length) {
        values.add(scanner.nextInt())
    }

    for (i in 0 until length) {
        weights.add(scanner.nextInt())
    }

    scanner.close()

    println("%.1f".format(weightedMean(values, weights)))
}
