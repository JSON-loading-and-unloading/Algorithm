// 메모리 : 2028KB , 시간 : 0ms, 시간 복잡도 : W(2^n) (n=N의 자릿수), B(n)

#include <algorithm>
#include <iostream>
#include <set>
#include <string>

using namespace std;

int range;

int n;
int m;
set<int> numSet;
string numString;
int result = 10e8;

void input() {
  for (int i = 0; i < 10; i++) {
    numSet.insert(i);
  }
  cin >> n >> m;
  numString = to_string(n);
  for (int i = 0; i < m; i++) {
    int num;
    cin >> num;
    numSet.erase(num);
  }
  range = abs(n - 100);
}

void output() { cout << result << '\n'; }

void dfs(int cnt, int buildNum, int restNum) {
  if (cnt == numString.length()) {
    int tmp = to_string(buildNum).size() + abs(restNum);
    result = min(result, tmp);
  } else {
    int minNum = 10e8;
    int nNum = numString[cnt] - '0' + restNum * 10;
    for (set<int>::iterator iter = numSet.begin(); iter != numSet.end();iter++) {
      if (minNum >= abs(nNum - *iter)) {
        minNum = abs(nNum - *iter);
      }
    }
    for (set<int>::iterator iter = numSet.begin(); iter != numSet.end();iter++) {
      if (cnt == 0) {
        dfs(cnt + 1, *iter, nNum - *iter);
        int tmp;
        if (*numSet.begin() == 0) {
          tmp = *(++numSet.begin()) * 10 + *numSet.begin();
        } else {
          tmp = *(numSet.begin()) * 10 + *numSet.begin();
        }
        dfs(cnt + 1, tmp, nNum - tmp);
        if (*iter == *(numSet.begin()) && numString.length() > 1) {
          dfs(cnt + 1, 0, nNum);
        }
      } else {
        if (minNum == abs(nNum - *iter)) {
          dfs(cnt + 1, buildNum * 10 + *iter, nNum - *iter);
        }
      }
    }
  }
}

void bruteForce() {
  dfs(0, 0, 0);
  result = min(result, range);
}

void start() {
  input();
  bruteForce();
  output();
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  start();
}