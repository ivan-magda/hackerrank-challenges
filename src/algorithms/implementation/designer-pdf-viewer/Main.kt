import java.util.*

private fun designerPdfViewer(heights: IntArray, word: String): Int {
    return word.length * (word.map { heights[it - 'a'] }.max() ?: 0)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val h = IntArray(26)

    for (h_i in 0..25) {
        h[h_i] = scanner.nextInt()
    }

    val word = scanner.next()
    val result = designerPdfViewer(h, word)

    println(result)
    scanner.close()
}
