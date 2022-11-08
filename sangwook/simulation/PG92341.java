package com.example.lib.java.simulation;

import java.util.*;

public class PG92341 {

    HashMap<String,ArrayList<String[]>> hm = new HashMap<>();
    ArrayList<Integer> ansList = new ArrayList<>();

    public int[] solution(int[] fees, String[] records) {

        for(int i = 0; i < records.length; i++){
            String[] record = records[i].split(" ");
            String carNum = record[1];
            String time = record[0];
            String action = record[2];

            if(hm.containsKey(carNum)){
                ArrayList<String[]> list = hm.get(carNum);
                list.add(new String[]{time,action});
                hm.put(carNum,list);

            }else{

                ArrayList<String[]> list = new ArrayList<>();
                list.add(new String[]{time,action});
                hm.put(carNum,list);
            }

        }
        System.out.println("SIZE : "+ hm.size());
        ArrayList<String[]> strList = new ArrayList<>();

        for(String key : hm.keySet()){
            ArrayList<String[]> li = hm.get(key);
            System.out.println(key);
            if(li.size() % 2 != 0){
                li.add(new String[]{"23:59","OUT"});
            }

            int totalTime = 0;
            for(int i = 0; i < li.size(); i+=2){

                String inTime = li.get(i)[0];
                String outTime = li.get(i+1)[0];

                String[] in = inTime.split(":");
                String[] out = outTime.split(":");

                int inTimeHour = Integer.parseInt(inTime.split(":")[0]);
                int inTimeMinute = Integer.parseInt(inTime.split(":")[1]);
                int outTimeHour = Integer.parseInt(outTime.split(":")[0]);
                int outTimeMinute = Integer.parseInt(outTime.split(":")[1]);


                int hour = 0;
                int minute = 0;
                if(outTimeMinute < inTimeMinute){
                    minute = outTimeMinute+60-inTimeMinute;
                    hour = outTimeHour - inTimeHour - 1;
                    if(hour < 0){
                        hour = 0;
                    }
                }else{
                    minute = outTimeMinute-inTimeMinute;
                    hour = outTimeHour - inTimeHour;
                }

                int spendTime = hour * 60 + minute;

                totalTime += spendTime;
            }
            System.out.println(totalTime);
            strList.add(new String[]{key,String.valueOf(totalTime)});


        }


        Collections.sort(strList, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2){
                int time1 = Integer.parseInt(s1[0]);
                int time2 = Integer.parseInt(s2[0]);

                return time1 - time2;
            }
        });

        for( int i = 0; i < strList.size(); i++){
            int time = Integer.parseInt(strList.get(i)[1]);

            if(time <= fees[0]){
                ansList.add(fees[1]);
            }else{
                int middle = 0;
                if((time - fees[0]) % fees[2] != 0){
                    middle = (time - fees[0]) / fees[2] + 1;
                }else{
                    middle = (time - fees[0]) /  fees[2];
                }
                System.out.println("middle "+middle);
                int price = fees[1] + middle * fees[3];
                ansList.add(price);
            }
        }
        int[] answer = new int[ansList.size()];

        for(int i = 0; i < ansList.size(); i++){
            answer[i] = (ansList.get(i));
        }
        return answer;
    }
}