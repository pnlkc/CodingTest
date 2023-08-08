class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int ranking = 1;
        int cnt = 1;
        int r = 0;
        
        p: while (true) {
            for (int i = 0; i < rank.length; i++) {
                if (rank[i] == ranking) {
                    if (attendance[i]) {
                        if (cnt == 1) r += i * 10_000;
                        else if (cnt == 2) r += i * 100;
                        else r += i;
                        ranking++;
                        if (cnt++ == 3) break p;
                    } else {
                        ranking++;
                        continue p;
                    }
                }
            }
        }
        return r;
    }
}