import java.io.*
import java.util.*

fun binarySearch(target: Int, array: Array<Int>): Int {
    var start = 0
    var end = array.lastIndex
    var middle: Int

    while (start <= end) {
        middle = start + (end - start) / 2
        val shot = array[middle]

        when {
            shot == target -> return middle
            shot < target -> start = middle + 1
            else -> end = middle - 1
        }
    }

    return -1
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    
    val target = scanner.nextInt()
    val size = scanner.nextInt()
    var array = Array(size, { 0 })
    
    for (i in 0 until size) {
        array[i] = scanner.nextInt()
    }
    scanner.close()
    
    println(binarySearch(target, array))
}
