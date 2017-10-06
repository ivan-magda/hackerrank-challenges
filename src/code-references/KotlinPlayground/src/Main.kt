/**
 * In operating systems that use paging for memory management, page replacement algorithm are needed to decide
 * which page needed to be replaced when new page comes in.
 * Whenever a new page is referred and not present in memory, page fault occurs and Operating System replaces one of
 * the existing pages with newly needed page.
 * Different page replacement algorithms suggest different ways to decide which page to replace.
 * The target for all algorithms is to reduce number of page faults.
 *
 * In Least Recently Used (LRU) algorithm is a Greedy algorithm where the page to be replaced is least recently used.
 * The idea is based on locality of reference, the least recently used page is not likely.
 *
 * Let say the page reference string 7 0 1 2 0 3 0 4 2 3 0 3 2 . Initially we have 4 page slots empty.
 * Initially all slots are empty, so when 7 0 1 2 are allocated to the empty slots —> 4 Page faults 0 is already their so —> 0 Page fault.
 * when 3 came it will take the place of 7 because it is least recently used —>1 Page fault 0 is already in memory so —> 0 Page fault.
 * 4 will takes place of 1 —> 1 Page Fault Now for the further page reference string —> 0 Page fault
 * because they are already available in the memory.
 */

private fun pageFaults(pages: Array<Int>, capacity: Int): Int {
    // To represent set of current pages.
    // We use an unordered_set so that we quickly check if a page is present in set or not.
    val currentPages = HashSet<Int>(capacity)

    // To store least recently used indexes of pages.
    val lruIndexes = HashMap<Int, Int>()
    var countPageFaults = 0

    for (i in 0 until pages.size) {
        val key = pages[i]

        // Insert it into set if not present already which represents page fault.
        if (currentPages.size < capacity && !currentPages.contains(key)) {
            currentPages.add(key)
            countPageFaults++
        } else if (!currentPages.contains(key)) {
            // If the set is full then need to perform lru
            // i.e. remove the least recently used page and insert the current page.
            val lruResult = performLRU(currentPages, lruIndexes)

            // Remove the indexes page.
            currentPages.remove(lruResult)

            // Insert the current page.
            currentPages.add(key)
            countPageFaults++
        }

        // Store the recently used index of each page.
        lruIndexes.put(key, i)
    }

    return countPageFaults
}

// Finds the least recently used pages that is present in the set.
private fun performLRU(pages: HashSet<Int>, indexes: HashMap<Int, Int>): Int {
    var lru = Int.MAX_VALUE
    var value = Int.MIN_VALUE

    val iterator = pages.iterator()
    while (iterator.hasNext()) {
        val current = iterator.next()
        if (indexes[current]!! < lru) {
            lru = indexes[current]!!
            value = current
        }
    }

    return value
}

fun main(args: Array<String>) {
    val pages = arrayOf(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2)
    println(pageFaults(pages, 4))
}
