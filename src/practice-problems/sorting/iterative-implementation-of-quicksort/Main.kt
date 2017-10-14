import java.util.*

fun quickSortIterative(array: Array<Int>) {
    val stack = Stack<Pair<Int, Int>>()

    var start = 0
    var end = array.lastIndex

    stack.push(Pair(start, end))

    while (!stack.isEmpty()) {
        val top = stack.pop()
        start = top.first
        end = top.second

        val pivotIndex = partition(array, start, end)

        // Push sub-array indexes containing elements that are
        // less than current pivot to stack.
        if (pivotIndex - 1 > start) {
            stack.push(Pair(start, pivotIndex - 1))
        }

        // Push sub-array indexes containing elements that are
        // more than current pivot to stack.
        if (pivotIndex + 1 < end) {
            stack.push(Pair(start + 1, end))
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
    val arrayQuickIterative = arrayOf(3, 21, 5, 4, 2, 6, 79, 43, 21, 4, 1)
    quickSortIterative(arrayQuickIterative)
    println(Arrays.toString(arrayQuickIterative))
}
