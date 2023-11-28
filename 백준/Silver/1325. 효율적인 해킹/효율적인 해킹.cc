#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    vector<vector<int>> graph(N + 1, vector<int>());
    vector<int> arr(N + 1, 0);

    for (int i = 1; i <= M; ++i) {
        int A, B;
        cin >> A >> B;

        graph[A].push_back(B);
    }

    for (int i = 1; i <= N; ++i) {
        vector<bool> isVisit(N + 1, false);
        queue<int> q;

        isVisit[i] = true;
        q.push(i);

        while (!q.empty()) {
            int c = q.front();
            q.pop();

            for (int next : graph[c]) {
                if (!isVisit[next]) {
                    arr[next]++;
                    isVisit[next] = true;
                    q.push(next);
                }
            }
        }
    }

    int maxCount = *max_element(arr.begin(), arr.end());

    for (int i = 1; i <= N; ++i) {
        if (arr[i] == maxCount) {
            cout << i << " ";
        }
    }

    cout << endl;

    return 0;
}