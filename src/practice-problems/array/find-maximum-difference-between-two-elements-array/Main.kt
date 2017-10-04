fun getMaxDiffNaive(array: Array<Int>): Int {
    var diff = Int.MIN_VALUE;

    for (i in 0 until array.size - 1) {
        for (j in i + 1 until array.size) {
            diff = Math.max(diff, array[j] - array[i])
        }
    }

    return diff
}

fun getMaxDiff(array: Array<Int>): Int {
    var diff = Int.MIN_VALUE
    var maxElement = array.last()

    for (i in array.size - 2 downTo 0) {
        val current = array[i]
        if (current > maxElement) {
            maxElement = current
        } else {
            diff = Math.max(diff, maxElement - current)
        }
    }

    return diff
}

fun main(args: Array<String>) {
    val array = arrayOf(2, 7, 9, 5, 1, 3, 5)
    println("The maximum difference = ${getMaxDiffNaive(array)} (Naive)")
    println("The maximum difference = ${getMaxDiff(array)} (Improved)")
}
