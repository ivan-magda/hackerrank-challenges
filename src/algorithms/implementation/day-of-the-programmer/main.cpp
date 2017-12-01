#include <sstream>
#include <cassert>
#include <iostream>

using namespace std;

int main() {
    int year;
    cin >> year;

    int daysInFebruary;

    if (year == 1918) {
        daysInFebruary = 28 - 13;
    } else if (year < 1918) {
        if (year % 4 == 0) {
            daysInFebruary = 29;
        } else {
            daysInFebruary = 28;
        }
    } else {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            daysInFebruary = 29;
        } else {
            daysInFebruary = 28;
        }
    }

    int day = 256 - 31 - daysInFebruary - 31 - 30 - 31 - 30 - 31 - 31;
    assert(1 <= day && day <= 30);

    printf("%02d.%02d.%04d", day, 9, year);

    return 0;
}
