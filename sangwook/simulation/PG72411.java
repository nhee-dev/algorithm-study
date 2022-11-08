package com.example.lib.java.simulation;

import java.util.*;

public class PG72411{

    HashMap<String,Integer> hm = new HashMap<String,Integer>();

    public String[] solution(String[] orders, int[] course) {


        Arrays.sort(orders, new Comparator<String>() {
            @Override
            public int compare(String i1, String i2) {
                return i1.length() - i2.length();
            }});

        for(int i = 0; i < orders.length; i++){
            String[] arr = orders[i].split("");
            Arrays.sort(arr);
            String str = "";
            for(int j = 0; j < arr.length; j++){
                str+=arr[j];
            }
            orders[i] = str;

        }

        for(int i = 0; i < orders.length;i++){

            String[] strArr = orders[i].split("");

            int n = strArr.length;

            for(int j = 0; j < course.length;j++){
                String[] output = new String[course[j]];
                comb(strArr,output,orders,0,0,course[j]);

            }

        }

        HashSet<ArrayList<String>> hs = new HashSet();

        for(int i = 0; i < course.length; i++){
            Iterator<String> keys = hm.keySet().iterator();
            int size = course[i];
            int max = -1;
            ArrayList<String> tmpList = new ArrayList<>();
            while(keys.hasNext()){
                String key = keys.next();

                if(hm.get(key) < 2){
                    continue;
                }
                if(key.length() != size){
                    continue;
                }
                if(hm.get(key) > max){
                    max = hm.get(key);
                    tmpList.clear();
                    tmpList.add(key);
                }else if(hm.get(key) == max){
                    tmpList.add(key);
                }


            }
            hs.add(tmpList);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>(hs);
        ArrayList<String> li  = new ArrayList<>();
        for(int i = 0; i < ans.size(); i++){
            for(int j = 0; j < ans.get(i).size(); j++){
                if(ans.get(i).get(j) != ""){
                    li.add(ans.get(i).get(j));
                }
            }
        }

        Collections.sort(li);
        System.out.println(li);
        String[] answer = new String[li.size()];
        for(int i = 0; i < li.size(); i++){
            answer[i] = li.get(i);
        }
        return answer;
    }

    public void comb(String[] strArr,String[] output, String[] orders, int cur, int start, int r){

        if(cur == r){

            checkMenu(output,orders);
            return;
        }

        for(int i = start; i < strArr.length; i++){
            output[cur] = strArr[i];
            comb(strArr,output,orders,cur+1,i+1,r);
        }
    }

    public void checkMenu(String[] menu, String[] orders){

        int cnt = 0;
        String str = "";

        for(int i = 0; i < menu.length; i++){
            str+=menu[i];
        }

        if(hm.containsKey(str)){
            return;
        }

        for(int i = 0; i < orders.length; i++){
            boolean flag = true;
            for(int j = 0; j < menu.length; j++){
                if(!orders[i].contains(menu[j])){
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(hm.containsKey(str)){
                    int value = hm.get(str) + 1;
                    hm.put(str,value);
                }else{
                    hm.put(str,1);
                }
            }

        }


    }
}