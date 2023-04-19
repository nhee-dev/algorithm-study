import java.util.*;

class Solution {
    static int[] arr, ans;
    static int result;
    static List<Sequence> list;

    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        ans = new int[2];
        list = new ArrayList<Sequence>();

        int sum = sequence[0];
        int left = 0;
        int right = 0;
        int size = sequence.length;

        while(true){
            if(sum == k) {
                list.add(new Sequence(left, right));
            }
            if(left == size && right == size) break;

            if(sum <= k && right < size){
                right++;
                if(right < size){
                    sum += sequence[right];
                }
            }else{
                if(left < size) sum -= sequence[left];
                left++;
            }

        }
        list.sort(Sequence::compareTo);
        ans[0] = list.get(0).left;
        ans[1] = list.get(0).right;
        return ans;
    }

}

class Sequence implements Comparable<Sequence>{
    int left;
    int right;
    int len;

    public Sequence(int left, int right){
        this.left = left;
        this.right = right;
        this.len = right - left;
    }

    @Override
    public int compareTo(Sequence o){
        if(this.len == o.len){
            return this.left - o.left;
        }
        return this.len - o.len;
    }

    @Override
    public String toString(){
        return this.len + " " + this.left + " " + this.right;
    }
}