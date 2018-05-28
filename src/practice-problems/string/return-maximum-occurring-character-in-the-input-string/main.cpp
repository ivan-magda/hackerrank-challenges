#include <cmath>
#include <iostream>

using namespace std;

static const int ASCII_SIZE = 256;

char mostFrequentCharacter(const char *str, int size) {
    int occurrences[ASCII_SIZE] = {0};
    int max = -1;
    char result = 0;

    for (int i = 0; i < size; ++i) {
        char character = str[i];
        int countCharacter = occurrences[character] + 1;

        if (countCharacter > max) {
            max = countCharacter;
            result = character;
        }
    }

    return result;
}

int main() {
    char str[] = "sample string";
    cout << "Max occurring character is "
         << mostFrequentCharacter(str, static_cast<int>(strlen(str)));

    return 0;
}