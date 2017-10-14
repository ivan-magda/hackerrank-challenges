package util

import java.io.File

class FileManager {

    companion object {
        private val INPUT_FILE_COUNT_PARTITIONS = 10
        private val INPUT_FILE_SIZE_PARTITION = 1000

        private val RANDOM_MAX_VALUE = 10000

        private val INPUT_FILE_NAME = "input.txt"
        private val OUTPUT_FILE_NAME = "output.txt"
    }

    private val inputFile = File(INPUT_FILE_NAME)
    private val outputFile = File(OUTPUT_FILE_NAME)

    fun generateInput() {
        inputFile.printWriter().use { out ->
            (0 until INPUT_FILE_COUNT_PARTITIONS * INPUT_FILE_SIZE_PARTITION)
                    .forEach { out.print("${RandomGenerator.getBetween(-RANDOM_MAX_VALUE, RANDOM_MAX_VALUE)} ") }
        }
    }
}
