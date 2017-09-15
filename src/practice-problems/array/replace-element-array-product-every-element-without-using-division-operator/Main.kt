import java.util.Arrays

/**
 * Function to replace each element of the array with product of every
 * other element without using division operator.
 */
fun findProduct(array: Array<Int>): Array<Int> {
    val left = array.clone()
    val right = array.clone()

    left[0] = 1
    for (i in 1 until array.size) {
        left[i] = array[i - 1] * left[i - 1]
    }

    right[array.size - 1] = 1
    for (i in array.size - 2 downTo 0) {
        right[i] = array[i + 1] * right[i + 1]
    }

    return left
            .zip(right)
            .map { (first, second) -> first * second }
            .toTypedArray()
}

fun main(args: Array<String>) {
    println("Product: ${Arrays.toString(findProduct(arrayOf(5, 3, 4, 2, 6, 8)))}")
}
