package model

interface MergeSortPartitionConfigurable {
    // Number of partitions of input file.
    val countPartitions: Int

    // The size of each partition.
    val sizePartition: Int
}
