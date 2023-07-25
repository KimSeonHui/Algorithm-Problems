class Solution {
    public int[] solution(String s) {
        int cnt = 0, zero = 0;
        
        while(!s.equals("1")) {
            //1
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i)=='0') {
                    zero++;     
                }
            }
            s = s.replaceAll("0", "");
            
            // 2
            s = change(s.length());
            cnt++;
        }
        
        return new int[]{cnt, zero};
    }
    
    static String change(int num) {
        String str = "";
        while(num > 0) {
            int rest = num%2;
            str += rest;
            num /= 2;
        }
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }
}