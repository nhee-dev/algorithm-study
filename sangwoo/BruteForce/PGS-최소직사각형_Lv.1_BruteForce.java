class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0, maxH = 0;
        
        for(int i = 0; i < sizes.length; i++) {
           if(sizes[i][0] < sizes[i][1]) {
               swap(sizes, i);
           }
            
            if(maxW < sizes[i][0]) {
                maxW = sizes[i][0];
            }
            if(maxH < sizes[i][1]) {
                maxH = sizes[i][1];
            }
        }
        
        return maxW * maxH;
    }
    
    public void swap(int[][] sizes, int idx) {
        int temp = sizes[idx][0];
        sizes[idx][0] = sizes[idx][1];
        sizes[idx][1] = temp;
    }
}