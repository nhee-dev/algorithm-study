class Solution {
    public int solution(int[][] sizes) {
        int max = 0, maxOfMin = 0;
        for (int[] size : sizes) {
			      max = Math.max(max, Math.max(size[0], size[1]));
            maxOfMin = Math.max(maxOfMin, Math.min(size[0], size[1]));
        }        
        
        int answer = max * maxOfMin;
        return answer;
    }
}

// class Solution {
    
//     public int solution(int[][] sizes) {
//         int max = getMax(sizes);
//         int maxOfMin = getMaxOfMin(sizes);
        
//         int answer = max * maxOfMin;
//         return answer;
//     }
    
//     int getMax(int[][] sizes) {
//         int max = 0;
//         for (int i = 0; i < sizes.length; i++) {
//             max = sizes[i][0] > max ? sizes[i][0] : max;
//             max = sizes[i][1] > max ? sizes[i][1] : max;
//         }
        
//         return max;
//     }
    
//     int getMaxOfMin(int[][] sizes) {
//         int maxOfMin = 0;
//         for (int i = 0; i < sizes.length; i++) {
//             if (sizes[i][0] < sizes[i][1]) {
//                 maxOfMin = sizes[i][0] > maxOfMin ? sizes[i][0] : maxOfMin;
//             }
//             else {
//                 maxOfMin = sizes[i][1] > maxOfMin ? sizes[i][1] : maxOfMin;
//             }
//         }
        
//         return maxOfMin;
//     }
// }
