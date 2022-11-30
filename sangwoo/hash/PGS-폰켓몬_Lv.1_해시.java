import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int N2 = (int)(nums.length / 2);
        if(set.size() > N2) {
            return N2;
        } else {
            return set.size();
        }
    }
}
