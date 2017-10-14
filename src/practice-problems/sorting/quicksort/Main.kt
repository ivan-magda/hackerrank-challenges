import java.util.*

fun quickSort(array: Array<Int>) {
    quickSort(array, 0, array.lastIndex)
}

fun quickSort(array: Array<Int>, start: Int, end: Int) {
    if (start < end) {
        // Rearrange the elements across pivot.
        val pivotIndex = partitionLomuto(array, start, end)

        // Recurse on sub-arrays.
        quickSort(array, start, pivotIndex - 1)
        quickSort(array, pivotIndex + 1, end)
    }
}

fun partitionLomuto(array: Array<Int>, start: Int, end: Int): Int {
    val pivot = array[end]

    // Elements less than pivot will be pushed to the left of pivotIndex.
    // Elements more than pivot will be pushed to the right of pivotIndex.
    // Equal elements can go either way.
    var pivotIndex = start

    for (i in start until end) {
        if (array[i] <= pivot) {
            swap(array, i, pivotIndex++)
        }
    }

    swap(array, pivotIndex, end)

    return pivotIndex
}

fun swap(array: Array<Int>, lhs: Int, rhs: Int) {
    val temp = array[lhs]
    array[lhs] = array[rhs]
    array[rhs] = temp
}

fun main(args: Array<String>) {
    val arrayQuick = arrayOf(3, 21, 5, 4, 2, 6, 79, 43, 21, 4, 1)
    quickSort(arrayQuick)
    println(Arrays.toString(arrayQuick))
}
