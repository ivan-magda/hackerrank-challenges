#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> buildVectorWithNumberOfInputs(const int numberOfInputs) {
    vector<int> vector;
    for (int i = 0; i < numberOfInputs; ++i) {
        int value;
        cin >> value;

        vector.push_back(value);
    }

    return vector;
}

int main() {
    int countArrays, queries;
    cin >> countArrays >> queries;

    vector<vector<int>> vector;
    for (int i = 0; i < countArrays; ++i) {
        int subVectorSize;
        cin >> subVectorSize;

        vector.push_back(buildVectorWithNumberOfInputs(subVectorSize));
    }

    for (int j = 0; j < queries; ++j) {
        int firstIdx, secondIdx;
        cin >> firstIdx >> secondIdx;

        cout << vector[firstIdx][secondIdx] << endl;
    }

    return 0;
}
