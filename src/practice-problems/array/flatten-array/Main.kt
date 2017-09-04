/**
 * Flatten Array.
 * @return ArrayList of elements from nested ArrayList's.
 */
fun flatten(array: ArrayList<*>): ArrayList<*> {
    val buffer = ArrayList<Any>(array.size)

    for (item in array) {
        when (item) {
            is ArrayList<*> -> buffer.addAll(flatten(item))
            else -> buffer.add(item)
        }
    }

    return buffer
}

fun main(args: Array<String>) {
    val result = flatten(arrayListOf(1, 2, 3, arrayListOf(4, 5, arrayListOf(6, 7))))
    println(result)
}
