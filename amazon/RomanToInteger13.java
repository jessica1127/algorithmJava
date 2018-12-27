import java.util.*;

/**
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
Example 1:
Input: "III"
Output: 3

Example 2:
Input: "IV"
Output: 4

Example 3:
Input: "IX"
Output: 9

Example 4:
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class RomanToInteger13{
    // private HashMap<String, Integer> map = new HashMap<String, Integer>();
    // map = buildMap();
    // private HashMap<String, Integer> buildMap(){
    //     private HashMap<String, Integer> res = new HashMap<String, Integer>();
    //     res.put("I", 1);
    //     res.put("V", 5);
    //     res.put("X", 10);
    //     res.put("L", 50);
    //     res.put("C", 100);
    //     res.put("D", 500);
    //     res.put("M", 1000);
    //     return res;

    // }


    public int romanToInt(String s) {
        if(s.length() == 0 || s == null ){
            return 0;
        }
        int res = toNumber(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(toNumber(s.charAt(i)) > toNumber(s.charAt(i-1))){
                res += toNumber(s.charAt(i)) - 2*(toNumber(s.charAt(i-1)));
            }else{
                res += toNumber(s.charAt(i));
            }
        }
        return res;
      }
      public static int toNumber(char c){
        int res = 0;
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return res;
    }

    public static void main(String[] args){
        String input = "III";
        RomanToInteger13 rti = new RomanToInteger13();
        int res = rti.romanToInt(input);
        System.out.println(res);
    }
}