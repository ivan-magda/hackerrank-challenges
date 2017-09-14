import java.util.*

fun reorder(array: Array<Int>) {
    var copyIndex = 0

    array
            .filter { it != 0 }
            .forEach { array[copyIndex++] = it }

    for (i in copyIndex until array.size) {
        array[i] = 0
    }
}

fun main(args: Array<String>) {
    val array = arrayOf(6, 0, 8, 2, 3, 0, 4, 0, 1)
    reorder(array)
    print(Arrays.toString(array))
}
