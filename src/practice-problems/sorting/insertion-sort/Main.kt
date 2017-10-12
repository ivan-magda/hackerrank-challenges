import java.util.*

fun insertionSort(array: Array<Int>) {
    for (i in 1 until array.size) {
        val value = array[i]
        var j = i - 1

        while (j >= 0 && array[j] > value) {
            array[j + 1] = array[j--]
        }
        array[j + 1] = value
    }
}

fun main(args: Array<String>) {
    val array = arrayOf(3, 21, 5, 4, 2, 6, 79, 43, 21, 4, 1)
    insertionSort(array)

    println(Arrays.toString(array))
}
