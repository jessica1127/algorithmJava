import java.math.*;
public class Solution {
    public int reverse(int x) {
        long res = 0;
        while(x != 0){
            res = res*10 + x%10;
            System.out.println("res=" + res);
            x = x/10;
        }
        return (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) ? 0:(int)res;
    }
    public static void main(String[] args){
       int input = 123;
       int intput2 = -136;
       Solution s = new Solution();
       int output = s.reverse(input);
       int output2 = s.reverse(intput2);
       System.out.println(output);
       System.out.println(output2);
    }
}