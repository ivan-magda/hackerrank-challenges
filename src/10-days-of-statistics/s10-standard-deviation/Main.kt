import java.util.*

private fun List<Int>.mean(): Double {
    var sum = 0

    for (element in this) {
        sum += element
    }

    return sum / size.toDouble()
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val count = scanner.nextInt()
    val data = ArrayList<Int>(count)

    for (i in 0 until count) {
        data.add(scanner.nextInt())
    }
    scanner.close()

    val mean = data.mean()
    val squaredDistances = Array(data.size, { Math.pow(data[it] - mean, 2.0) })
    val standardDeviation = Math.sqrt(squaredDistances.sum() / squaredDistances.size.toDouble())

    println("%.1f".format(standardDeviation))
}
