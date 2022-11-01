import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Record> map = new HashMap<>();
        StringTokenizer st;
        for(int i = 0; i < records.length; i++) {
            st = new StringTokenizer(records[i]);
            int time = getTime(st.nextToken());
            String car = st.nextToken();
            if(st.nextToken().equals("IN")) {
                if(map.get(car) == null) {
                    map.put(car, new Record(time));
                } else {
                    map.get(car).in(time);   
                }
            } else {
                map.get(car).out = time;
            }
        }        
        
        String[] cars = new String[map.size()];
        int[] answer = new int[cars.length];
        int idx = 0;
        for(String str : map.keySet()) {
            cars[idx++] = str;
        }
        Arrays.sort(cars);
        
        for(int i = 0; i < cars.length; i++) {
            if(map.get(cars[i]).out == -1) {
                map.get(cars[i]).out = 1439;
            }
            map.get(cars[i]).total += map.get(cars[i]).out - map.get(cars[i]).in;
            
            answer[i] = cal(map.get(cars[i]).total, fees);
        }
        return answer;
    }
    
    public int cal(int time, int[] fees) {
        if(time <= fees[0]) {
            return fees[1];
        }
        
        int div = (int)(time - fees[0]) % fees[2];       
        int fee = (int)((time - fees[0]) / fees[2]) * fees[3];
        if(div > 0) {
            fee += fees[3];
        }
        
        return fees[1] + fee;
    }
    
    public int getTime(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        return (60 * h) + m;        
    }
}

class Record {
    int in, out, total;
    public Record(int in) {
        this.in = in;
        out = -1;
        total = 0;
    }
    public void in(int time) {
        total += out - in;
        in = time;
        out = -1;
    }
    @Override
    public String toString() {
        return "in: " + in + ", out: " + out + ", total: " + total;
    }
}