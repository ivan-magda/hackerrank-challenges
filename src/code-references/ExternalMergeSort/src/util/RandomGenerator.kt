package util

import model.RandomGenerative
import java.util.*

class RandomGenerator() : RandomGenerative {

    companion object {
        private val MAX_VALUE = 10000
        private val MIN_VALUE = -MAX_VALUE
    }

    override val low: Int
        get() = MIN_VALUE
    override val high: Int
        get() = MAX_VALUE

    override fun nextInt(): Int {
        return getBetween(low, high)
    }

    private val random = Random()

    private fun getBetween(low: Int, high: Int): Int {
        return random.nextInt(high - low) + low
    }
}
