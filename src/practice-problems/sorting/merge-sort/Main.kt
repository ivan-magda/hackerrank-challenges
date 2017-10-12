import java.util.*

fun mergeSort(array: Array<Int>) {
    mergeSort(array, Array(array.size, { 0 }), 0, array.size - 1)
}

fun mergeSort(array: Array<Int>, buffer: Array<Int>, start: Int, end: Int) {
    if (start < end) {
        val middle = start + (end - start) / 2

        mergeSort(array, buffer, start, middle)
        mergeSort(array, buffer, middle + 1, end)
        merge(array, buffer, start, middle, end)
    }
}

fun merge(array: Array<Int>, buffer: Array<Int>, start: Int, middle: Int, end: Int) {
    var copy = start
    var lhs = start
    var rhs = middle + 1

    while (lhs <= middle && rhs <= end) {
        if (array[lhs] <= array[rhs]) {
            buffer[copy++] = array[lhs++]
        } else {
            buffer[copy++] = array[rhs++]
        }
    }

    System.arraycopy(array, lhs, buffer, copy, middle - lhs + 1)
    System.arraycopy(array, rhs, buffer, copy, end - rhs + 1)
    System.arraycopy(buffer, start, array, start, end - start + 1)
}

fun main(args: Array<String>) {
    val arrayMerge = arrayOf(3, 21, 5, 4, 2, 6, 79, 43, 21, 4, 1)
    mergeSort(arrayMerge)
    println(Arrays.toString(arrayMerge))
}
