#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int count;
    cin >> count;

    vector<int> intVector = vector<int>();
    for (int i = 0; i < count; ++i) {
        int inputValue;
        cin >> inputValue;

        intVector.push_back(inputValue);
    }

    reverse(intVector.begin(), intVector.end());
    for (vector<int>::iterator it = intVector.begin(); it != intVector.end(); ++it) {
        cout << *it << ' ';
    }

    return 0;
}
