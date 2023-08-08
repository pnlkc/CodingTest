class Solution {
    public String solution(String a, String b) {
        String result = "";
        String newA = a;
        String newB = b;
        int diff = Math.abs(a.length() - b.length());
        String str = "";
        for (int i = 0; i < diff; i++) {
            str += "0";        
        }
        
        if (a.length() < b.length()) {
            newA = str + newA;
        } else {
            newB = str + newB;
        }
        
        int addNum = 0;
        for (int i = newA.length() - 1; i >= 0; i--) {
            int ac = Integer.parseInt(String.valueOf(newA.charAt(i)));
            int bc = Integer.parseInt(String.valueOf(newB.charAt(i)));
            int sum = ac + bc + addNum;
            result = sum % 10 + result;
            addNum = sum / 10;
        }
        
        if (addNum != 0) result = addNum + result;
        
        return result;
    }
}