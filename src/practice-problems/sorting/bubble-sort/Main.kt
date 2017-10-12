import java.util.*

fun bubbleSort(array: Array<Int>) {
    for (i in 0 until array.size - 1) {
        for (j in 0 until array.size - 1 - i) {
            if (array[j] > array[j + 1]) {
                swap(array, j, j + 1)
            }
        }
    }
}

fun swap(array: Array<Int>, lhs: Int, rhs: Int) {
    val temp = array[lhs]
    array[lhs] = array[rhs]
    array[rhs] = temp
}

fun main(args: Array<String>) {
    val arrayBubble = arrayOf(3, 21, 5, 4, 2, 6, 79, 43, 21, 4, 1)
    bubbleSort(arrayBubble)
    println(Arrays.toString(arrayBubble))
}
