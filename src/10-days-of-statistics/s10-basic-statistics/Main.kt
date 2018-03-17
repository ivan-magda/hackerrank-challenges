import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun List<Int>.mean(): Float {
    var sum = 0

    for (element in this) {
        sum += element
    }

    return sum / size.toFloat()
}

fun List<Int>.median(): Float {
    val sorted = sorted()
    val middle = (size - 1) / 2

    return if (sorted.size % 2 != 0) {
        sorted[middle].toFloat()
    } else {
        (sorted[middle] + sorted[middle + 1]) / 2F
    }
}

fun List<Int>.mode(): Int {
    val map = HashMap<Int, Int>(size)
    for (element in this) {
        map[element] = map.getOrDefault(element, 0) + 1
    }

    val entry = Collections.max(
            map.entries,
            Comparator { o1, o2 ->
                val valDiff = o1.value - o2.value

                if (valDiff == 0) {
                    return@Comparator o2.key - o1.key
                }

                return@Comparator valDiff
            }
    )

    return entry.key
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    var n = scanner.nextInt()
    val list = ArrayList<Int>(n)

    while (n-- > 0) {
        list.add(scanner.nextInt())
    }
    scanner.close()

    println("%.1f".format(list.mean()))
    println("%.1f".format(list.median()))
    println(list.mode())
}
