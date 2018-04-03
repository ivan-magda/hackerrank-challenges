import java.util.*

private fun getMoneySpent(money: Int, keyboards: Array<Int>, usbDrives: Array<Int>): Int {
    var spent = -1

    for (keyboard in keyboards) {
        for (usb in usbDrives) {
            val total = keyboard + usb
            if (total in (spent + 1)..money) {
                spent = total
            }
        }
    }

    return spent
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val money = scanner.nextInt()
    val countKeyboardBrands = scanner.nextInt()
    val countUSBBrands = scanner.nextInt()

    val keyboardsBrands = Array(countKeyboardBrands, { 0 })
    val usbBrands = Array(countUSBBrands, { 0 })

    for (i in 0 until countKeyboardBrands) {
        keyboardsBrands[i] = scanner.nextInt()
    }

    for (i in 0 until countUSBBrands) {
        usbBrands[i] = scanner.nextInt()
    }

    scanner.close()

    println(getMoneySpent(money, keyboardsBrands, usbBrands))
}
