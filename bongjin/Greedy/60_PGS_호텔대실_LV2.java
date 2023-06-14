import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] arr = new int[book_time.length][2];
        List<Time> list = new ArrayList<Time>();
        PriorityQueue<Integer> pq = new PriorityQueue();
                
        for(int i = 0; i < book_time.length; i++){
            for(int j = 0; j < 2; j++){
                int hour = Integer.parseInt(book_time[i][j].substring(0,2)) * 60;
                int minute = Integer.parseInt(book_time[i][j].substring(3,5));
                arr[i][j] = hour + minute;               
            }
            list.add(new Time(arr[i][0], arr[i][1] + 10));
        }              
        
        list.sort(Time::compareTo);  
        
        pq.offer(list.get(0).end);       
        for(int i = 1; i < list.size(); i++){
            if(pq.peek() <= list.get(i).start ){
                pq.poll();
            }
            pq.offer(list.get(i).end);
        }
        
        
        
        return pq.size();
    }
}

class Time implements Comparable<Time>{
    int start;
    int end;
    public Time(int s, int e){
        this.start = s;
        this.end = e;
    }
    
    @Override
    public int compareTo(Time t){
        if(this.start == t.start){
            return this.end - t.end;
        }
        return this.start - t.start;
    }
    
    @Override
    public String toString(){
        return this.start + " ~ " + this.end;
    }
}