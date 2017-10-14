import java.util.*

val INSERTION_SORT_TRESHOLD = 10

fun insertionSort(array: Array<Int>, start: Int, end: Int) {
    for (i in start..end) {
        val key = array[i]
        var j = i - 1

        while (j >= start && array[j] > key) {
            array[j + 1] = array[j--]
        }
        array[j + 1] = key
    }
}

fun optimizedQuickSort(array: Array<Int>) {
    optimizedQuickSort(array, 0, array.lastIndex)
}

fun optimizedQuickSort(array: Array<Int>, start: Int, end: Int) {
    var low = start
    var high = end

    while (low < high) {
        if (low - high <= INSERTION_SORT_TRESHOLD) {
            insertionSort(array, low, high)
            break
        } else {
            val pivotIndex = partition(array, low, high)

            if (pivotIndex - low < high - pivotIndex) {
                optimizedQuickSort(array, low, pivotIndex - 1)
                low = pivotIndex + 1
            } else {
                optimizedQuickSort(array, pivotIndex + 1, high)
                high = pivotIndex - 1
            }
        }
    }
}

fun partition(array: Array<Int>, start: Int, end: Int): Int {
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
    val arrayQuickOptimized = arrayOf(3, 21, 5, 4, 2, 6, 79, 43, 21, 4, 1)
    optimizedQuickSort(arrayQuickOptimized)
    println(Arrays.toString(arrayQuickOptimized))
}
