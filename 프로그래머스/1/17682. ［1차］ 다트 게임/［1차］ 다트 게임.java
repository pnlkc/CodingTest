class Solution {
    public int solution(String dartResult) {
        int[] list = new int[3];
        int idx = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c >= '0' && c <= '9') {
                String str = "" + c;

                if (i != dartResult.length() - 1 && dartResult.charAt(i + 1) == '0') {
                    str += '0';
                    i++;
                }

                list[idx++] = Integer.parseInt(str);
            } else {
                if (c == 'D') {
                    list[idx - 1] = list[idx - 1] * list[idx - 1];
                } else if (c == 'T') {
                    list[idx - 1] = list[idx - 1] * list[idx - 1] * list[idx - 1];
                }

                if (c == '*') {
                    if (idx - 2 >= 0) {
                        list[idx - 2] = list[idx - 2] * 2;
                    }

                    list[idx - 1] = list[idx - 1] * 2;
                } else if (c == '#') {
                    list[idx - 1] = list[idx - 1] * -1;
                }
            }
        }

        int answer = list[0] + list[1] + list[2];

        return answer;
    }
}