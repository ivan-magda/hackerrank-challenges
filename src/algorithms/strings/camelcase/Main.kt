import java.util.*

fun countWords(string: String): Int {
    return (1 until string.length).count { string[it].isUpperCase() && string[it - 1].isLowerCase() }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`);

    val string = scanner.next();
    val countWords = countWords(string)
    print(countWords)

    scanner.close()
}
