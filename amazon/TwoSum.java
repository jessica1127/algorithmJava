//TwoSum: return true if there is a pair summing up to a target
import java.util.*;


public class TwoSum{
 
public int[] twoSum(int[] nums, int target) {
    if(nums==null || nums.length<2)
        return new int[]{0,0};
 
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i=0; i<nums.length; i++){
        if(map.containsKey(nums[i])){
            return new int[]{map.get(nums[i]), i};
        }else{
            map.put(target-nums[i], i);
        }
    }
 
    return new int[]{0,0};
}

public static void main(String[] args){
    int target = 9;
    int[] nums = {7, 1,8,11,15};
    TwoSum ts = new TwoSum();
    int[] result = ts.twoSum(nums, target);
    System.out.println(Arrays.toString(result));
    
}
}