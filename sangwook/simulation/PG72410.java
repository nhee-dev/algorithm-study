package com.example.lib.java.simulation;

import java.util.*;
public class PG72410 {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();

        //1단계
        new_id = new_id.toLowerCase();

        //2단계
        StringBuilder newId = new StringBuilder();

        for(int i = 0; i < new_id.length(); i++) {

            char c = new_id.charAt(i);

            if((c >='a' && c <= 'z' ) ||(c >='0' && c <= '9' )  || c  == '-'|| c == '_' || c == '.'){
                newId.append(c);
            }

        }

        //3단계
        while(newId.toString().contains("..")){
            newId = new StringBuilder(newId.toString().replace("..", "."));
        }


        //4단계
        ArrayList<Character> newIdList = new ArrayList();
        for(int i = 0; i < newId.length(); i++){
            newIdList.add(newId.charAt(i));
        }


        while(newIdList.size() > 0 && newIdList.get(0) == '.'){
            newIdList.remove(0);

        }

        while(newIdList.size() > 0 && newIdList.get(newIdList.size()-1) == '.'){
            newIdList.remove(newIdList.size()-1);

        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < newIdList.size(); i++){
            str.append(newIdList.get(i));
        }

        //5단계
        if(str.toString().equals("")){
            str.append("a");
        }

        //6단계
        if(str.length()>=16){
            str = new StringBuilder(str.substring(0, 15));
        }

        ArrayList<Character> strList = new ArrayList();
        for(int i = 0; i < str.length(); i++){
            strList.add(str.charAt(i));
        }

        while(strList.size() > 0 && strList.get(strList.size()-1) == '.'){
            strList.remove(strList.size()-1);

        }

        //7단계
        while(strList.size() < 3){
            strList.add(strList.get(strList.size()-1));
        }

        for(int i = 0; i < strList.size(); i++){
            answer.append(strList.get(i));
        }

        return answer.toString();
    }
}