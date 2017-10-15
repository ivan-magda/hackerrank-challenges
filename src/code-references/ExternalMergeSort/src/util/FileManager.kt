package util

import model.MergeSortPartitionConfigurable
import model.MinHeapNode
import model.RandomGenerative
import model.Sortable
import java.io.File
import java.io.FileWriter
import java.util.*
import kotlin.Comparator

interface FileManagerConfigurator {
    val partition: MergeSortPartitionConfigurable
    val inputFileName: String
    val outputFileName: String
}

class FileManager(private val configurator: FileManagerConfigurator) {

    private val inputFile = File(configurator.inputFileName)
    private val outputFile = File(configurator.outputFileName)

    fun generateInput(generator: RandomGenerative) {
        val size = configurator.partition.countPartitions * configurator.partition.sizePartition
        inputFile.printWriter().use { out ->
            (0 until size)
                    .forEach { out.print("${generator.nextInt()} ") }
        }
    }

    // Creates sorted output files.
    fun createScratchFiles(sortDirector: Sortable<Int>) {
        val scanner = Scanner(inputFile)
        val outputFiles = Array(configurator.partition.countPartitions, { File("$it") })
        val array = Array(configurator.partition.sizePartition, { 0 })

        var outputFileIndex = 0

        while (scanner.hasNextInt()) {
            var i = 0
            while (scanner.hasNextInt() && i < configurator.partition.sizePartition) {
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
        if (outputFile.exists()) {
            outputFile.delete()
        }

        val inputScanners = getInputScanners()
        val minHeap = PriorityQueue<MinHeapNode>(
                configurator.partition.countPartitions,
                Comparator { o1: MinHeapNode, o2: MinHeapNode -> o1.element - o2.element }
        )

        // Push first element of each file into the min-heap
        // along with list number (index).
        for (i in 0 until configurator.partition.countPartitions) {
            val scanner = inputScanners[i]
            if (scanner.hasNextInt()) {
                minHeap.add(MinHeapNode(scanner.nextInt(), i))
            }
        }

        val fileWriter = FileWriter(configurator.outputFileName, true)

        while (!minHeap.isEmpty()) {
            val minNode = minHeap.poll()
            fileWriter.write("${minNode.element} ")

            // Take next element from the same file and
            // insert it into min-heap.
            val scanner = inputScanners[minNode.index]
            if (scanner.hasNextInt()) {
                minNode.element = scanner.nextInt()
                minHeap.add(minNode)
            }
        }

        fileWriter.close()
        closeScanners(inputScanners)
    }

    private fun getInputScanners(): Array<Scanner> {
        val inputFiles = Array(configurator.partition.countPartitions, { File("$it") })
        return Array(inputFiles.size, { Scanner(inputFiles[it]) })
    }

    private fun closeScanners(scanners: Array<Scanner>) {
        for (anScanner in scanners) {
            anScanner.close()
        }
    }
}
