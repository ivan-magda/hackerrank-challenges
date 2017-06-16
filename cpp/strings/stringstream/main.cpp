#include <sstream>
#include <vector>
#include <iostream>

using namespace std;

vector<int> parseInts(string str) {
    vector<int> intVector = vector<int>();

    stringstream ss(str);
    string temp;
    int number;

    while (getline(ss, temp, ',')) {
        if (stringstream(temp) >> number) {
            intVector.push_back(number);
        }
    }

    return intVector;
}

int main() {
    string str;
    cin >> str;

    vector<int> integers = parseInts(str);
    for (int i = 0; i < integers.size(); i++) {
        cout << integers[i] << "\n";
    }

    return 0;
}
