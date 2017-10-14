package util

import model.MergeSortPartitionConfigurable
import model.RandomGenerative
import java.io.File

class FileManager(private val partitionConfigurator: MergeSortPartitionConfigurable) {

    companion object {
        private val INPUT_FILE_NAME = "input.txt"
        private val OUTPUT_FILE_NAME = "output.txt"
    }

    private val inputFile = File(INPUT_FILE_NAME)
    private val outputFile = File(OUTPUT_FILE_NAME)

    fun generateInput(generator: RandomGenerative) {
        val size = partitionConfigurator.countPartitions * partitionConfigurator.sizePartition
        inputFile.printWriter().use { out ->
            (0 until size)
                    .forEach { out.print("${generator.nextInt()} ") }
        }
    }
}
