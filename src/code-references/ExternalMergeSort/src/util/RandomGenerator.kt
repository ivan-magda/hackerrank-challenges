package util

import java.util.*

class RandomGenerator {

    companion object {
        private val random = Random()

        fun getBetween(low: Int, high: Int): Int {
            return random.nextInt(high - low) + low
        }
    }
}
