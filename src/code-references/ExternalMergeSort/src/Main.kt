import model.MergeSortPartitionConfigurable
import sort.MergeSort
import util.FileManager
import util.RandomGenerator

private const val INPUT_FILE_COUNT_PARTITIONS = 10
private const val INPUT_FILE_SIZE_PARTITION = 1000

fun main(args: Array<String>) {
    val fileManager = FileManager(object : MergeSortPartitionConfigurable {
        override val countPartitions: Int
            get() = INPUT_FILE_COUNT_PARTITIONS
        override val sizePartition: Int
            get() = INPUT_FILE_SIZE_PARTITION
    })
    fileManager.generateInput(generator = RandomGenerator())

    // Read the input file, create initial runs and assign the runs
    // to the scratch output files.
    fileManager.createInitialRuns(sortDirector = MergeSort())

    // Merge the runs using K-way merging.
    fileManager.mergeFiles()
}
