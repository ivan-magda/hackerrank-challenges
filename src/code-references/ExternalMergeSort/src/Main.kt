import model.MergeSortPartitionConfigurable
import sort.MergeSort
import util.FileManager
import util.FileManagerConfigurator
import util.RandomGenerator

private const val INPUT_FILE_NAME = "input.txt"
private const val OUTPUT_FILE_NAME = "output.txt"

private const val INPUT_FILE_COUNT_PARTITIONS = 10
private const val INPUT_FILE_SIZE_PARTITION = 1000

fun main(args: Array<String>) {
    val partitionConfigurator = object : MergeSortPartitionConfigurable {
        override val countPartitions: Int
            get() = INPUT_FILE_COUNT_PARTITIONS
        override val sizePartition: Int
            get() = INPUT_FILE_SIZE_PARTITION
    }

    val fileManager = FileManager(object : FileManagerConfigurator {
        override val partition: MergeSortPartitionConfigurable
            get() = partitionConfigurator
        override val inputFileName: String
            get() = INPUT_FILE_NAME
        override val outputFileName: String
            get() = OUTPUT_FILE_NAME
    })
    fileManager.generateInput(generator = RandomGenerator())

    // Read the input file, create initial runs and assign the runs
    // to the scratch output files.
    fileManager.createScratchFiles(sortDirector = MergeSort())

    // Merge the runs using K-way merging.
    fileManager.mergeFiles()
}
