import java.util.*;


class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        if(digits == null || digits.length() == 0 ){
            return res;
        }
        StringBuffer sb = new StringBuffer();
        dfsHelper(digits, 0, res, sb, map );
        return res;
    }

    private void dfsHelper(String digits, int index, List<String> res, StringBuffer sb, HashMap<Integer, String> map){
        //base case
        if(digits.length() == index){
            res.add(sb.toString());
            return;
        }
        int ch = digits.charAt(index) - '0';
        String values = map.get(ch);
        for(char val : values.toCharArray()){
            sb.append(val);
            dfsHelper(digits, index+1, res, sb, map);
            //
            System.out.println("sb= " + sb.toString());
            sb.deleteCharAt(sb.length()-1);
            
        }
    }
}

public class LetterCombinationOfAPhone17 {
    public static void main(String[] args){
        Solution s = new Solution();
        String digits = "23";
        List<String> res = new ArrayList<String>();
        res = s.letterCombinations(digits);
        System.out.println("res= " + res.toString());
    }
}