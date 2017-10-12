import java.util.*

fun selectionSort(array: Array<Int>) {
    for (i in 0 until array.size - 1) {
        val minIndex = findMinIndex(array, i, array.lastIndex)
        swap(array, minIndex, i)
    }
}

fun findMinIndex(array: Array<Int>, start: Int, end: Int): Int {
    var minIndex = start
    for (i in (start + 1)..end) {
        if (array[i] < array[minIndex]) {
            minIndex = i
        }
    }

    return minIndex
}

fun swap(array: Array<Int>, lhs: Int, rhs: Int) {
    val temp = array[lhs]
    array[lhs] = array[rhs]
    array[rhs] = temp
}

fun main(args: Array<String>) {
    val arraySelection = arrayOf(3, 21, 5, 4, 2, 6, 79, 43, 21, 4, 1)
    println("Selection Sort:")
    selectionSort(arraySelection)
    println(Arrays.toString(arraySelection))
}
