#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;


int main(){
    int count;
    cin >> count;
    
    vector<int> arr(count);
    
    for (int i = 0; i < count; i++){
       cin >> arr[i];
    }
    
    for (int i = arr.size() - 1; i >= 0; i--) {
        cout << arr[i] << " ";
    }
    
    return 0;
}
