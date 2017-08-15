#### Method 1
```cpp
int INF = std::numeric_limits<int>::max();
```
#### Method 2
```cpp
#include <limits.h>
int INF = INT_MAX;
int negativeINF = INT_MIN;

// Also note to get the largest possible long or long long value:
long INF = LONG_MAX;
long long INF = LLONG_MAX;
```
