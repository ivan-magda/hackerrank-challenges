package util

import model.MergeSortPartitionConfigurable
import model.MinHeapNode
import model.RandomGenerative
import model.Sortable
import java.io.File
import java.io.FileWriter
import java.util.*
import kotlin.Comparator

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

    fun createInitialRuns(sortDirector: Sortable<Int>) {
        val scanner = Scanner(inputFile)
        val outputFiles = Array(partitionConfigurator.countPartitions, { File("$it") })
        val array = Array(partitionConfigurator.sizePartition, { 0 })

        var outputFileIndex = 0

        while (scanner.hasNextInt()) {
            var i = 0
            while (scanner.hasNextInt() && i < partitionConfigurator.sizePartition) {
                array[i++] = scanner.nextInt()
            }

            sortDirector.sort(array)

            outputFiles[outputFileIndex++].printWriter().use { out ->
                (0 until i)
                        .forEach { out.print("${array[it]} ") }
            }
        }

        scanner.close()
    }

    fun mergeFiles() {
        outputFile.delete()
        val inputFiles = Array(partitionConfigurator.countPartitions, { File("$it") })
        val priorityQueue = PriorityQueue<MinHeapNode>(
                partitionConfigurator.countPartitions,
                Comparator { o1: MinHeapNode, o2: MinHeapNode -> o1.element - o2.element }
        )

        var i = 0
        while (i < partitionConfigurator.countPartitions) {
            val scanner = Scanner(inputFiles[i])
            if (scanner.hasNextInt()) {
                priorityQueue.add(MinHeapNode(scanner.nextInt(), i++))
            } else {
                break
            }
        }

        val fileWriter = FileWriter(OUTPUT_FILE_NAME, true)
        var scanner: Scanner? = null
        var count = 0

        while (count < i) {
            val root = priorityQueue.poll()
            fileWriter.write("${root.element} ")

            if (scanner == null) {
                scanner = Scanner(inputFiles[root.index])
            }

            if (scanner.hasNextInt()) {
                root.element = scanner.nextInt()
            } else {
                scanner.close()
                scanner = null
                root.element = Int.MAX_VALUE
                count++
            }

            priorityQueue.add(root)
        }

        fileWriter.close()
    }
}
