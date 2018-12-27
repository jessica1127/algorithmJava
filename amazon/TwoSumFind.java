import java.util.*;
//Two sum:  return true if there’s a pair summing up to a target

public class TwoSumFind{
    public boolean findSum(int[] nums, int target){
        if(nums == null || nums.length < 2){
            return false;
        }

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++){
            if (map.containsKey(nums[i])){
                return true;
            }else{
                map.put(target-nums[i], i);
            }
        }
        return false;
    }
    public static void main(String[] args){
        int target = 4;
        int[] nums = {0, 2, 5, 15};
        TwoSumFind ts = new TwoSumFind();
        boolean result = ts.findSum(nums, target);
        System.out.println("Final result = " + Boolean.valueOf(result));
    }
}