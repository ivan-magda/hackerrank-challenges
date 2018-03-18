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

    constructor(data: List<Int>, frequencies: List<Int>? = null) : this() {
        if (frequencies != null) {
            assert(data.size == frequencies.size)
            buildData(data, frequencies)
        } else {
            this.data = data
        }

        findQuartiles()
    }

    private fun findQuartiles() {
        Collections.sort(data)

        val lowerHalf = ArrayList<Int>(data.size / 2)
        val upperHalf = ArrayList<Int>(data.size / 2)

        for (i in 0 until data.size / 2) {
            lowerHalf.add(data[i])
        }

        if (isOdd(data)) {
            for (i in (data.size / 2) + 1 until data.size) {
                upperHalf.add(data[i])
            }
        } else {
            for (i in data.size / 2 until data.size) {
                upperHalf.add(data[i])
            }
        }

        first = medianOf(lowerHalf)
        second = medianOf(data)
        third = medianOf(upperHalf)
        IQR = third - first
    }

    private fun medianOf(list: List<Int>): Float {
        val middle = list.size / 2

        return if (isOdd(list)) {
            list[middle].toFloat()
        } else {
            (list[middle] + list[middle - 1]) / 2F
        }
    }

    private fun buildData(data: List<Int>, frequencies: List<Int>) {
        val list = ArrayList<Int>(data.size * frequencies.first())

        for (i in 0 until data.size) {
            val element = data[i]
            for (j in 0 until frequencies[i]) {
                list.add(element)
            }
        }

        this.data = list
    }

    private fun isOdd(list: List<Int>): Boolean {
        return (list.size and 1) == 1
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val count = scanner.nextInt()
    val data = ArrayList<Int>(count)
    val frequencies = ArrayList<Int>(count)

    for (i in 0 until count) {
        data.add(scanner.nextInt())
    }
    for (i in 0 until count) {
        frequencies.add(scanner.nextInt())
    }
    scanner.close()

    val quartiles = Quartiles(data, frequencies)
    println("%.1f".format(quartiles.IQR))
}
