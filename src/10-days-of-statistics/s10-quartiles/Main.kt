import java.util.*
import kotlin.collections.ArrayList

private class Quartiles private constructor() {

    var first = 0F
        private set
    var second = 0F
        private set
    var third = 0F
        private set
    var IQR = 0F
        private set

    private lateinit var data: List<Int>

    constructor(data: List<Int>) : this() {
        this.data = data
        findQuartiles()
    }

    private fun findQuartiles() {
        Collections.sort(data)

        second = medianOf(data)

        val lowerHalf = data.filter { it < second }
        val upperHalf = data.filter { it > second }

        first = medianOf(lowerHalf)
        third = medianOf(upperHalf)
        IQR = third - first
    }

    private fun medianOf(list: List<Int>): Float {
        val middle = (list.size - 1) / 2

        return if (list.size % 2 != 0) {
            list[middle].toFloat()
        } else {
            (list[middle] + list[middle + 1]) / 2F
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val count = scanner.nextInt()
    val list = ArrayList<Int>(count)

    for (i in 0 until count) {
        list.add(scanner.nextInt())
    }
    scanner.close()

    val quartile = Quartiles(list)
    println(quartile.first)
    println(quartile.second)
    println(quartile.third)
}
