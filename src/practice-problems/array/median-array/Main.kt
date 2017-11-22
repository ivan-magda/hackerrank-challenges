import java.util.*
import kotlin.Comparator

/****************
 * @param list an ArrayList of Comparable objects
 * @return the median of list
 */
fun <T : Number> median(list: ArrayList<T>, comp: Comparator<T>): Double {
    val result: Double
    val n = list.size / 2

    result = if (list.size % 2 == 0)
    // even number of items; find the middle two and average them
        (nth(list, n - 1, comp).toDouble() + nth(list, n, comp).toDouble()) / 2.0
    else
    // odd number of items; return the one in the middle
        nth(list, n, comp).toDouble()

    return result
}

/*****************
 * @param list a collection of Comparable objects
 * @param n  the position of the desired object, using the ordering defined on the list elements
 * @return the nth smallest object
 */
fun <T> nth(list: ArrayList<T>, n: Int, comp: Comparator<T>): T {
    val result: T
    val underPivot = ArrayList<T>()
    val overPivot = ArrayList<T>()
    val equalPivot = ArrayList<T>()

    // choosing a pivot is a whole topic in itself.
    // this implementation uses the simple strategy of grabbing something from the middle of the ArrayList.

    val pivot = list[n / 2]

    // split list into 3 lists based on comparison with the pivot

    for (value in list) {
        val order = comp.compare(value, pivot)

        when {
            order < 0
                // value < pivot
            -> underPivot.add(value)
            order > 0
                // value > pivot
            -> overPivot.add(value)
            else
                // value = pivot
            -> equalPivot.add(value)
        }
    }

    // recurse on the appropriate list

    result = when {
        n < underPivot.size -> nth(underPivot, n, comp)
        n < underPivot.size + equalPivot.size -> pivot // equal to pivot; just return it
        else
            // everything in underPivot and equalPivot is too small.  Adjust n accordingly in the recursion.
        -> nth(overPivot, n - underPivot.size - equalPivot.size, comp)
    }

    return result
}

fun main(args: Array<String>) {
    val comp = Comparator.naturalOrder<Int>()
    val rnd = Random()

    for (size in 1..10) {
        val coll = ArrayList<Int>(size);
        for (i in 0 until size) {
            coll.add(rnd.nextInt(100))
        }

        println("Median of " + coll.toString() + " is " + median(coll, comp));
    }
}
