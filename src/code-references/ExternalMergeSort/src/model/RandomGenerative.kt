package model

interface RandomGenerative {
    val low: Int
    val high: Int

    fun nextInt(): Int
}
