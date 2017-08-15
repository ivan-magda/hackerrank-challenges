#include <string>
#include <iostream>

using namespace std;

int main() {
    string firstString;
    string secondString;

    cin >> firstString >> secondString;

    cout << firstString.size() << " " << secondString.size() << endl;
    cout << firstString + secondString << endl;

    char temp = firstString[0];
    firstString[0] = secondString[0];
    secondString[0] = temp;

    cout << firstString << " " << secondString << endl;

    return 0;
}
