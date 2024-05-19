#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <climits>
#include <algorithm>

using namespace std;

int answer = INT_MAX;
set<int> used;

void calc(const vector<int>& tuning, const vector<int>& code, vector<vector<int>>& result, int idx) {
    if (idx == tuning.size()) {
        int minVal = INT_MAX;
        int maxVal = 0;

        for (int i = 0; i < tuning.size(); ++i) {
            used.insert(result[i][0]);
            if (result[i][1] != 0) {
                minVal = min(minVal, result[i][1]);
                maxVal = max(maxVal, result[i][1]);
            }
        }

        if (used.size() == code.size()) {
            answer = min(answer, (minVal == INT_MAX) ? 0 : maxVal - minVal + 1);
        }

        used.clear();
        return;
    }

    for (int next : code) {
        result[idx][0] = next;
        result[idx][1] = next - tuning[idx];
        if (next < tuning[idx]) result[idx][1] += 12;
        calc(tuning, code, result, idx + 1);
        result[idx][1] += 12;
        calc(tuning, code, result, idx + 1);
    }
}

int main() {
    map<string, int> scaleMap = {
        {"A", 1}, {"A#", 2}, {"B", 3}, {"C", 4}, {"C#", 5},
        {"D", 6}, {"D#", 7}, {"E", 8}, {"F", 9}, {"F#", 10},
        {"G", 11}, {"G#", 12}
    };

    int N, M;
    cin >> N >> M;
    vector<int> tuning(N), code(M);
    string note;

    for (int i = 0; i < N; ++i) {
        cin >> note;
        tuning[i] = scaleMap[note];
    }

    for (int i = 0; i < M; ++i) {
        cin >> note;
        code[i] = scaleMap[note];
    }

    vector<vector<int>> result(N, vector<int>(2, 0));

    calc(tuning, code, result, 0);

    cout << answer << endl;

    return 0;
}
